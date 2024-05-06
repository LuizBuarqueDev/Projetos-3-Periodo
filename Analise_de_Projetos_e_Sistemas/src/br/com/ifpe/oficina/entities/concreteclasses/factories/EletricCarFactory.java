package br.com.ifpe.oficina.entities.concreteclasses.factories;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.car.EletricCar;
import br.com.ifpe.oficina.interfaces.IAbstractCarFactory;


public class EletricCarFactory implements IAbstractCarFactory {

	public static EletricCarFactory eletricCarFactory() {
		
		return new EletricCarFactory();
	}

	@Override
	public Car createCar() {
		// TODO Auto-generated method stub
		return EletricCar.create();
	}
}