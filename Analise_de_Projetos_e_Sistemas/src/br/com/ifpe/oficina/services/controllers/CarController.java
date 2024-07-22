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

public class CarController implements IController<Car> {

	private static final CarController instance = new CarController();

	DAOFactory daoFactory = new DAOFactory();

	GenericDAO<Car> carDAO = daoFactory.createDAO(Car.class);

	private CarController() {
	}

	public static CarController getInstance() {
		return instance;
	}

	private Car searchCar(String plate) {
		Predicate<Car> filterByCar = car -> car.getPlate().equals(plate);
		return carDAO.search(filterByCar);
	}

	public void create(String type, String plate, String traction) {
		Car car = searchCar(plate);
		if (car != null) {
			throw new NoSuchElementException("A placa '" + plate + "'já existe");
		}
		if (type.equals("1")) {
			car = new CombustionCar();
			car.setClient(null);
			car.setPlate(plate);
			car.setTraction(traction);
			
		} else if (type.equals("2")) {
			car = new EletricCar();
			car.setClient(null);
			car.setPlate(plate);
			car.setTraction(traction);
			
		} else {
			throw new IllegalArgumentException("Tipo de carro invalido");
		}
		
		car.setClient(new Client.ClientBuilder().build());
		
		carDAO.create(car);
	}

	@Override
	public Car read(String plate) {
		Car car = searchCar(plate);
		if (car == null) {
			throw new NoSuchElementException("A placa '" + plate + "' não foi encontrada");
		}
		return carDAO.read(car);
	}

	public void update(String plate, String traction) {
		// TODO: Modificar o acesso direto a lista
		Car car = searchCar(plate);

		if (car == null) {
			throw new NoSuchElementException("A placa '" + plate + "' não foi encontrada");
		}
		car.setPlate(plate);
		car.setTraction(traction);
		car.setTraction(traction);
	}

	@Override
	public void delete(String plate) {
		Car car = searchCar(plate);
		if (car == null) {
			throw new NoSuchElementException("A placa '" + plate + "' não foi encontrada");
		}
		carDAO.delete(car);
	}

	@Override
	public List<Car> viewAll() {
		return carDAO.viewAll();
	}
}
