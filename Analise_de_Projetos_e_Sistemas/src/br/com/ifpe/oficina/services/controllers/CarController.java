package br.com.ifpe.oficina.services.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.interfaces.IController;
import br.com.ifpe.oficina.persistence.GenericDAO;

public class CarController implements IController<Car> {
	
	private static final CarController instance = new CarController();
	
	private GenericDAO<Car> carDAO = GenericDAO.createInstance();
	
	private CarController() {}
	
	public static CarController getInstance() {
		return instance;
	}

	private Car searchCar(String plate) {
	    return viewAll().stream()
	            .filter(car -> car.getPlate().equals(plate))
	            .findFirst()
	            .orElse(null);
	}	

	public void create(String plate) {
		// TODO Auto-generated method stub

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
		
		if(car == null) {
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
