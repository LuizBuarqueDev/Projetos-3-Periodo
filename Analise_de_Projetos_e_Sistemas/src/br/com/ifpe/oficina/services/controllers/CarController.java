package br.com.ifpe.oficina.services.controllers;

import java.util.List;
import java.util.function.Predicate;

import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.entities.decorator.Carpets;
import br.com.ifpe.oficina.entities.decorator.HeatedSeats;
import br.com.ifpe.oficina.entities.decorator.IBasicCar;
import br.com.ifpe.oficina.persistence.GenericDAO;
import br.com.ifpe.oficina.services.factories.DAOFactory;

public class CarController extends GenericController<IBasicCar> implements IController<IBasicCar>, ICarController {

    private static final CarController instance = new CarController(DAOFactory.createDAO(IBasicCar.class));

    private CarController(GenericDAO<IBasicCar> dao) {
        super(dao);
    }

    public static CarController getInstance() {
        return instance;
    }

    private IBasicCar searchCar(String plate) {
        Predicate<IBasicCar> filterByCar = car -> car.getInnerCar().getPlate().equals(plate);
        return dao.read(filterByCar);
    }

    @Override
    public IBasicCar applyAccessories(IBasicCar car, int carpets, int seats) {
        for (int i = 0; i < carpets; i++) {
            car = new Carpets(car);
        }

        for (int i = 0; i < seats; i++) {
            car = new HeatedSeats(car);
        }
        return car;
    }

    @Override
    public void create(IBasicCar car) {
        try {
            genericInsert(car);
        } catch (Exception e) {
            ClientController.getInstance().delete(car.getInnerCar().getClient().getCpf(), false);
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public IBasicCar read(String plate) {
        return genericRead(searchCar(plate));
    }

    @Override
    public void update(IBasicCar newCar) {
        IBasicCar oldCar = searchCar(newCar.getInnerCar().getPlate());
        if (oldCar == null) {
            throw new RuntimeException("Update error: Car not found");
        }
        newCar.getInnerCar().setClient(oldCar.getInnerCar().getClient());
        int index = viewAll().indexOf(oldCar);
        genericUpdate(index, newCar);
    }

    @Override
    public void delete(String plate, boolean isDeletingClient) {
        IBasicCar car = searchCar(plate);
        genericDelete(car);
        if (isDeletingClient) {
            Client client = car.getInnerCar().getClient();
            if (client != null) {
                ClientController.getInstance().delete(client.getCpf(), false);
            }
        }
    }

    @Override
    public List<IBasicCar> viewAll() {
        return genericListAll();
    }

    @Override
    protected void validateInsert(IBasicCar car) {
        if (searchCar(car.getInnerCar().getPlate()) != null) {
            throw new RuntimeException("Validate insert error: Unable to insert plate already exists");
        }
    }

    @Override
    protected void validateUpdate(IBasicCar car) {
        if (searchCar(car.getInnerCar().getPlate()) == null) {
            throw new RuntimeException("Validate update error: Plate not found");
        }
    }
}