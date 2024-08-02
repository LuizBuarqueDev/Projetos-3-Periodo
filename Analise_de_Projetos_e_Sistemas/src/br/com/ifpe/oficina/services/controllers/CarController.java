package br.com.ifpe.oficina.services.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.entities.concreteclasses.CombustionCar;
import br.com.ifpe.oficina.entities.concreteclasses.EletricCar;
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
        return genericRead(filterByCar);
    }

    @Override
    protected void validateInsert(Car car) {
        if (searchCar(car.getPlate()) != null) {
            throw new RuntimeException("A placa ja existe");
        }
    }

    @Override
    protected void validateUpdate(Car car) {
        System.out.println("Foi validado");
        if (searchCar(car.getPlate()) != null) {
            throw new RuntimeException("A placa ja existe");
        }
    }

    @Override
    public void create(String... attributes) {
        String type = attributes[0];
        String plate = attributes[1];
        String traction = attributes[2];
        if (type.equals("1")) {
            Car car = CombustionCar.CombustionCarBuilder.aCombustionCar()
                    .client(Client.ClientBuilder().build())
                    .plate(plate)
                    .traction(traction)
                    .build();

            genericInsert(car);

        } else if (type.equals("2")) {
            Car car = EletricCar.EletricCarBuilder.anEletricCar()
                    .client(Client.ClientBuilder().build())
                    .plate(plate)
                    .traction(traction)
                    .build();

            genericInsert(car);

        } else {
            throw new IllegalArgumentException("Tipo de carro invalido");
        }
    }

    @Override
    public Car read(String plate) {
        return searchCar(plate);
    }

    @Override
    public void update(String... attributes) {
        String oldPlate = attributes[0];
        String newPlate = attributes[1];
        String traction = attributes[2];

        Car car = searchCar(oldPlate);
        try {
            Car carCopy = (Car) car.clone();
            carCopy.setPlate(newPlate);
            carCopy.setTraction(traction);

            int index = viewAll().indexOf(car);
            genericUpdate(index, carCopy);
        } catch (Exception e) {
            throw new RuntimeException("Carro não encontrado");
        }
    }

    public void delete(String plate) {
        Car car = searchCar(plate);
        if (car == null) {
            throw new NoSuchElementException("A placa '" + plate + "' não foi encontrada");
        }
        dao.delete(car);
    }

    @Override
    public List<Car> viewAll() {
        return dao.viewAll();
    }
}
