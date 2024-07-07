package br.com.ifpe.oficina.services.factories;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.SilkCar;
import br.com.ifpe.oficina.interfaces.IAbstractCarFactory;

public class SilkFactory implements IAbstractCarFactory{

	public static SilkFactory silkFactory() {
		return new SilkFactory();
	}
	
	@Override
	public Car createCar() {
		return new SilkCar();
	}
}
