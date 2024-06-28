package br.com.ifpe.oficina.entities.concreteclasses;

import br.com.ifpe.oficina.entities.abstractclasses.Car;

public class SilkCar extends Car{
	
	public static SilkCar create() {
		return new SilkCar();
	}
	
	private SilkCar() {
		// TODO Auto-generated constructor stub
		this.engine = "Combustion Engine";
	}

	@Override
	public String toString() {
		return "SilkFactory [plate=" + plate + ", engine=" + engine + ", traction=" + traction + ", client=" + client.getName()
				+ "]";
	}
}
