package br.com.ifpe.oficina.entities.concreteclasses;

import br.com.ifpe.oficina.entities.abstractclasses.Car;

public class SilkCar extends Car{
	
	public SilkCar() {
		this.engine = "Combustion Engine";
	}

	@Override
	public String toString() {
		return "SilkFactory [plate=" + plate + ", engine=" + engine + ", traction=" + traction + ", client=" + client.getName()
				+ "]";
	}
}
