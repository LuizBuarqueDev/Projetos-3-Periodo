package br.com.ifpe.oficina.business;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.MechanicManager;
import br.com.ifpe.oficina.interfaces.IController;

public class Controller implements IController {
	
	public static Controller createController() {
		return new Controller();
	}
	
	private Controller() {
		
	}
	@Override
	public Car searchCar(String plate) {
		MechanicManager mechanicManager = MechanicManager.getInstance();
		
		for (Car car : mechanicManager.getCarList()) {
			if (car.getPlate().equals(plate)) {
				return car;
			}
		}
		throw new NullPointerException("A placa '" + plate + "' não foi encontrada");
	}
}
