package br.com.ifpe.oficina.entities.concreteclasses;

import br.com.ifpe.oficina.entities.abstractclasses.Car;

public class EletricCar extends Car {
	
	private int batteryCapacity;
	
	public EletricCar() {
		this.engine = "Eletric Engine";
		this.batteryCapacity = 1000;
	}

	@Override
	public String toString() {
		return "EletricCar [batteryCapacity=" + batteryCapacity + ", plate=" + plate + ", engine=" + engine
				+ ", traction=" + traction + ", client=" + client.getName() + "]";
	}
	
	
}
