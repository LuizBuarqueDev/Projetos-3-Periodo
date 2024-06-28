package br.com.ifpe.oficina.services.factories;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.JeepCar;
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
