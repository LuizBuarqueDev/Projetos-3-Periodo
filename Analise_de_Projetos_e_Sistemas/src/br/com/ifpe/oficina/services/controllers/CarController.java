package br.com.ifpe.oficina.services.controllers;

import java.util.function.Predicate;

import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.entities.decorator.Carpets;
import br.com.ifpe.oficina.entities.decorator.HeatedSeats;
import br.com.ifpe.oficina.entities.decorator.IBasicCar;
import br.com.ifpe.oficina.persistence.GenericDAO;
import br.com.ifpe.oficina.services.factories.DAOFactory;

public class CarController extends GenericController<IBasicCar> implements ICarController {

    private static final CarController instance = new CarController(DAOFactory.createDAO(IBasicCar.class));

    private CarController(GenericDAO<IBasicCar> dao) {
        super(dao);
    }

    public static CarController getInstance() {
        return instance;
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
    protected IBasicCar search(String plate) {
        Predicate<IBasicCar> filterByCar = car -> car.getInnerCar().getPlate().equals(plate);
        return dao.read(filterByCar);
    }

    @Override
    protected void validateInsert(IBasicCar car) {
        if (search(car.getInnerCar().getPlate()) != null) {
            throw new RuntimeException("Validate insert error: Unable to insert plate already exists");
        }
    }

    @Override
    protected IBasicCar validateUpdate(IBasicCar newCar) {
        IBasicCar oldCar = search(newCar.getInnerCar().getPlate());
        if (oldCar == null) {
            throw new RuntimeException("Validate update error: Plate not found");
        }
        newCar.getInnerCar().setClient(oldCar.getInnerCar().getClient());
        return oldCar;
    }

    @Override
    protected void afterDelete(IBasicCar car, boolean deleteAssociation) {
        Client client = car.getInnerCar().getClient();
        if (client != null && deleteAssociation) {
            ClientController.getInstance().delete(client.getCpf(), false);
        }
    }

    @Override
    protected void fixInsert(IBasicCar car) {
        ClientController.getInstance().delete(car.getInnerCar().getClient().getCpf(), false);
    }
}