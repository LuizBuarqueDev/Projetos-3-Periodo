package br.com.ifpe.oficina.services.factories;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.SilkCar;
import br.com.ifpe.oficina.interfaces.IAbstarctFactory;

public class SilkFactory implements IAbstarctFactory<Car>{

	public static SilkFactory silkFactory() {
		return new SilkFactory();
	}

	@Override
	public Car create() {
		return new SilkCar();
	}
}
