package br.com.ifpe.oficina.entities.concreteclasses;

import br.com.ifpe.oficina.entities.abstractclasses.Car;

public class CombustionCar extends Car {
	
	public CombustionCar() {
		this.engine = "Combustion Engine";
	}

	@Override
	public String toString() {
		return "CombustionCar [plate=" + plate + ", engine=" + engine
				+ ", traction=" + traction + ", client=" + client.getName() + "]";
	}
}
