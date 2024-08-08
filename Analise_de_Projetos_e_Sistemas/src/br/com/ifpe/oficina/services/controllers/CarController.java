package br.com.ifpe.oficina.services.controllers;

import java.util.List;
import java.util.function.Predicate;

import br.com.ifpe.oficina.entities.abstractclasses.Carpets;
import br.com.ifpe.oficina.entities.abstractclasses.HeatedSeats;
import br.com.ifpe.oficina.entities.concreteclasses.Car;
import br.com.ifpe.oficina.interfaces.IController;
import br.com.ifpe.oficina.persistence.GenericDAO;
import br.com.ifpe.oficina.services.factories.DAOFactory;

public class CarController extends GenericController<Car> implements IController<Car> {

    private static final CarController instance = new CarController(DAOFactory.createDAO(Car.class));

    private CarController(GenericDAO<Car> dao) {
        super(dao);
    }

    public static CarController getInstance() {
        return instance;
    }

    private Car searchCar(String plate) {
        Predicate<Car> filterByCar = car -> car.getPlate().equals(plate);
        return dao.read(filterByCar);
    }

    private Car applyAccessories(Car car, int carpets, int seats) {
        for (int i = 0; i < carpets; i++) {
            car = new Carpets(car);
        }

        for (int i = 0; i < seats; i++) {
            car = new HeatedSeats(car);
        }
        System.out.print(car.getPrice());
        return car;
    }

    @Override
    public void create(Car car, String... attributes) {
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
    public Car read(String plate) {
        return genericRead(searchCar(plate));
    }

    @Override
    public void update(Car newCar, String... attributes) {
        Car oldCar = searchCar(newCar.getPlate());
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

        applyAccessories(newCar, carpets, seats);
        int index = viewAll().indexOf(oldCar);
        genericUpdate(index, newCar);
    }

    @Override
    public void delete(String plate) {
        genericDelete(searchCar(plate));
    }

    @Override
    public List<Car> viewAll() {
        return genericListAll();
    }

    @Override
    protected void validateInsert(Car car) {
        if (searchCar(car.getPlate()) != null) {
            throw new RuntimeException("Não foi possivel inserir placa já existe");
        }
    }

    @Override
    protected void validateUpdate(Car car) {
        if (searchCar(car.getPlate()) != null) {
            throw new RuntimeException("A placa já existe");
        }
    }
}