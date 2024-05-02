package br.com.ifpe.oficina.entities.concreteclasses.car;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.interfaces.ICarFactory;

public class EletricCarFactory extends Car implements ICarFactory{
	
	private static EletricCarFactory instance = new  EletricCarFactory();
	
	public static EletricCarFactory getinstance() {
		return instance;
	}
	
	public EletricCarFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public EletricCarFactory(String plate, String chassis, int age) {
		super(plate, chassis, age);
		this.engine = "Eletric engine";
	}

	@Override
	public Car createCar(String plate, String chassis, int age) {
		// TODO Auto-generated method stub
		return new EletricCarFactory(plate, chassis, age);
	}

	@Override
	public String toString() {
		return "EletricCarFactory [plate=" + plate + ", chassis=" + chassis + ", age=" + age + ", engine=" + engine
				+ "]";
	}
}