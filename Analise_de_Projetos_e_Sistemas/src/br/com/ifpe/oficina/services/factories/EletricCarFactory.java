package br.com.ifpe.oficina.services.factories;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.EletricCar;
import br.com.ifpe.oficina.interfaces.IAbstarctFactory;

public class EletricCarFactory implements IAbstarctFactory<Car>{

	public static EletricCarFactory eletricCarFactory() {
		return new EletricCarFactory();
	}

	@Override
	public Car create() {
		return new EletricCar();
	}
}