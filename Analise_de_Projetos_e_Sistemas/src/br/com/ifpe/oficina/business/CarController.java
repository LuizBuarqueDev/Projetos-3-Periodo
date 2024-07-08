package br.com.ifpe.oficina.business;

import java.util.List;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.interfaces.IController;
import br.com.ifpe.oficina.persistence.CarDAOImpl;

public class CarController implements IController {
	
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
	
	CarDAOImpl carDAOImpl = CarDAOImpl.getInstance();

	@Override
	public void create(String plate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Car read(String plate) {
		return searchCar(plate);
	}

	@Override
	public void update(String plate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String plate) {
		carDAOImpl.delete(searchCar(plate));
	}

	@Override
	public List<Car> viewAll() {
		return CarDAOImpl.getInstance().viewAll();
	}
}
