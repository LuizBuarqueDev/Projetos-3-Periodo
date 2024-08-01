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

public class CarController extends GenericController<Car> implements  IController<Car>{

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

    protected void validateInsert(Car car) {
        if (searchCar(car.getPlate()) != null) {
            throw new RuntimeException("O carro já existe");
        }
    }

    @Override
    public void create(String... attributes) {
        String type = attributes[0];
        String plate = attributes[1];
        String traction = attributes[2];
        if (type.equals("1")){
            Car car = CombustionCar.CombustionCarBuilder.aCombustionCar()
                    .client(Client.ClientBuilder().build())
                    .plate(plate)
                    .traction(traction)
                    .build();

            insert(car);

        } else if (type.equals("2")) {
            Car car = EletricCar.EletricCarBuilder.anEletricCar()
                    .client(Client.ClientBuilder().build())
                    .plate(plate)
                    .traction(traction)
                    .build();

            insert(car);

        } else {
            throw new IllegalArgumentException("Tipo de carro invalido");
        }
    }

    @Override
    public Car read(String plate) {
        Car car = searchCar(plate);
        if (car == null) {
            throw new NoSuchElementException("A placa '" + plate + "' não foi encontrada");
        }
        return car;
    }

    @Override
    public void update(String... attributes) {

    }

    public void update(String plate, String traction) {
        Car car = searchCar(plate);
        if (car == null) {
            throw new NoSuchElementException("A placa '" + plate + "' não foi encontrada");
        }
        try {
            Car carCopy = (Car) car.clone();
            carCopy.setPlate(plate);
            carCopy.setPlate(traction);
            carCopy.setTraction(traction);

//            carDAO.update(viewAll().indexOf(car), carCopy);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar o objeto carro");
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
        return listAll();
    }
}
