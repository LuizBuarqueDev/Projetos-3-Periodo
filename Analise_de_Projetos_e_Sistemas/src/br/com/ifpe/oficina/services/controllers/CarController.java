package br.com.ifpe.oficina.services.controllers;

import java.util.List;
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
        return dao.read(filterByCar);
    }

    private Car createCombustionCar(String plate, String traction) {
        return CombustionCar.CombustionCarBuilder.aCombustionCar()
                .client(Client.ClientBuilder().build())
                .plate(plate)
                .traction(traction)
                .build();
    }

    private Car createElectricCar(String plate, String traction) {
        return EletricCar.EletricCarBuilder.anEletricCar()
                .client(Client.ClientBuilder().build())
                .plate(plate)
                .traction(traction)
                .build();
    }

    @Override
    public void create(String... attributes) {
        String type = attributes[0];
        String plate = attributes[1];
        String traction = attributes[2];

        Car car = switch (type) {
            case "1" -> createCombustionCar(plate, traction);
            case "2" -> createElectricCar(plate, traction);
            default -> throw new IllegalArgumentException("Tipo de carro inválido");
        };
        genericInsert(car);
    }

    @Override
    public Car read(String plate) {
        return genericRead(searchCar(plate));
    }

    @Override
    public void update(String... attributes) {
        String oldPlate = attributes[0];
        String newPlate = attributes[1];
        String traction = attributes[2];

        Car car = searchCar(oldPlate);
        if (car == null) {
            throw new RuntimeException("Carro não encontrado");
        }

        try {
            Car carCopy = (Car) car.clone();
            carCopy.setPlate(newPlate);
            carCopy.setTraction(traction);

            int index = viewAll().indexOf(car);
            genericUpdate(index, carCopy);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao clonar o carro", e);
        }
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
            System.out.println("Placa ja existe pae");
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