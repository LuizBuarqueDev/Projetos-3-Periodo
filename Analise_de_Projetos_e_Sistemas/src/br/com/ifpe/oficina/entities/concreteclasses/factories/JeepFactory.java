package br.com.ifpe.oficina.entities.concreteclasses.factories;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.car.JeepCar;
import br.com.ifpe.oficina.interfaces.IAbstractCarFactory;

public class JeepFactory implements IAbstractCarFactory{
	
	public static JeepFactory jeepFactory() {
		return new JeepFactory();
	}

	@Override
	public Car createCar() {
		// TODO Auto-generated method stub
		return JeepCar.create();
	}
}
