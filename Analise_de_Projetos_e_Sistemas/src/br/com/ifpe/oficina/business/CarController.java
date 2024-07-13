package br.com.ifpe.oficina.business;

import java.util.List;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.interfaces.IController;
import br.com.ifpe.oficina.persistence.GenericDAO;

public class CarController implements IController<Car> {

	public static CarController createController() {
		return new CarController();
	}

	private CarController() {
	}

	private Car searchCar(String plate) {
		List<Car> carList = viewAll();

		for (Car car : carList) {
			if (car.getPlate().equals(plate)) {
				return car;
			}
		}
		throw new NullPointerException("A placa '" + plate + "' não foi encontrada");
	}

	GenericDAO<Car> carDAO = GenericDAO.createInstance();

	public void create(String plate) {
		// TODO Auto-generated method stub

	}

	@Override
	public Car read(String plate) {
		return carDAO.read(searchCar(plate));
	}

	public void update(String plate, String traction, Client client) {
		Car car = searchCar(plate);
		car.setTraction(traction);
		car.setClient(client);
		int index = viewAll().indexOf(car);
		carDAO.update(index, car);
	}

	@Override
	public void delete(String plate) {
		carDAO.delete(searchCar(plate));
	}

	@Override
	public List<Car> viewAll() {
		return carDAO.viewAll();
	}
}
