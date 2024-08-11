package br.com.ifpe.oficina.services.controllers;

import java.util.List;
import java.util.function.Predicate;

import br.com.ifpe.oficina.entities.decorator.Carpets;
import br.com.ifpe.oficina.entities.decorator.HeatedSeats;
import br.com.ifpe.oficina.entities.decorator.IBasicCar;
import br.com.ifpe.oficina.persistence.GenericDAO;
import br.com.ifpe.oficina.services.factories.DAOFactory;

public class CarController extends GenericController<IBasicCar> implements IController<IBasicCar> {

    private static final CarController instance = new CarController(DAOFactory.createDAO(IBasicCar.class));

    private CarController(GenericDAO<IBasicCar> dao) {
        super(dao);
    }

    public static CarController getInstance() {
        return instance;
    }

    private IBasicCar searchCar(String plate) {
        Predicate<IBasicCar> filterByCar = car -> car.getPlate().equals(plate);
        return dao.read(filterByCar);
    }

    private IBasicCar applyAccessories(IBasicCar car, int carpets, int seats) {
        for (int i = 0; i < carpets; i++) {
             car = new Carpets(car);
        }

        for (int i = 0; i < seats; i++) {
             car = new HeatedSeats(car);
        }
        return car;
    }

    @Override
    public void create(IBasicCar car, String... attributes) {
        int carpets;
        int seats;
        try {
            carpets = Integer.parseInt(attributes[0]);
            seats = Integer.parseInt(attributes[1]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Acessorios invalidos");
        }
        car = applyAccessories(car, carpets, seats);
        genericInsert(car);
    }

    @Override
    public IBasicCar read(String plate) {
        return genericRead(searchCar(plate));
    }

    @Override
    public void update(IBasicCar newCar, String... attributes) {
        IBasicCar oldCar = searchCar(newCar.getPlate());
        if (oldCar == null) {
            throw new RuntimeException("Carro não encontrado");
        }
        int carpets;
        int seats;
        try {
            carpets = Integer.parseInt(attributes[0]);
            seats = Integer.parseInt(attributes[1]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Acessorios invalidos");
        }
        newCar.setClient(oldCar.getClient());
        applyAccessories(newCar, carpets, seats);
        int index = viewAll().indexOf(oldCar);
        genericUpdate(index, newCar);
    }

    @Override
    public void delete(String plate) {
        genericDelete(searchCar(plate));
    }

    @Override
    public List<IBasicCar> viewAll() {
        return genericListAll();
    }

    @Override
    protected void validateInsert(IBasicCar car) {
        if (searchCar(car.getPlate()) != null) {
            throw new RuntimeException("Não foi possivel inserir placa já existe");
        }
    }

    @Override
    protected void validateUpdate(IBasicCar car) {
        if (searchCar(car.getPlate()) == null) {
            throw new RuntimeException("Placa não encontrada");
        }
    }
}