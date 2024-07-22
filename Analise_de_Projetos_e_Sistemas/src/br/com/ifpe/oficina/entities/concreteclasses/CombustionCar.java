package br.com.ifpe.oficina.entities.concreteclasses;

import br.com.ifpe.oficina.entities.abstractclasses.Car;

public class CombustionCar extends Car {
	
	private boolean differentialLock;
	
	public CombustionCar() {
		this.engine = "Combustion Engine";
	}

	public boolean isDifferentialLock() {
		return differentialLock;
	}

	public void setDifferentialLock(boolean differentialLock) {
		this.differentialLock = differentialLock;
	}

	@Override
	public String toString() {
		return "CombustionCar [differentialLock=" + differentialLock + ", plate=" + plate + ", engine=" + engine
				+ ", traction=" + traction + ", client=" + client.getName() + "]";
	}
}
