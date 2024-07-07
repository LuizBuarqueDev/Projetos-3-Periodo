package br.com.ifpe.oficina.entities.concreteclasses;

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

	@Override
	public String toString() {
		return "EletricCar [batteryCapacity=" + batteryCapacity + ", plate=" + plate + ", engine=" + engine
				+ ", traction=" + traction + ", client=" + client.getName() + "]";
	}
	
	
}
