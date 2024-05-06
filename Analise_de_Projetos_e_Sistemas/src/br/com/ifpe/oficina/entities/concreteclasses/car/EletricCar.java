package br.com.ifpe.oficina.entities.concreteclasses.car;

import br.com.ifpe.oficina.entities.abstractclasses.Car;

public class EletricCar extends Car {
	
	private int batteryCapacity;
	
	public EletricCar() {
		// TODO Auto-generated constructor stub
		this.engine = "Eletric Engine";
	}
	
	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
}
