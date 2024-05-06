package br.com.ifpe.oficina.entities.concreteclasses.car;

import br.com.ifpe.oficina.entities.abstractclasses.Car;

public class JeepCar  extends Car {
	
	private boolean differentialLock;
	
	public static JeepCar create() {
		return new JeepCar();
	}
	
	private JeepCar() {
		this.engine = "Combustion Engine";
		// TODO Auto-generated constructor stub
	}

	public boolean isDifferentialLock() {
		return differentialLock;
	}

	public void setDifferentialLock(boolean differentialLock) {
		this.differentialLock = differentialLock;
	}

	@Override
	public String toString() {
		return "JeepCar [differentialLock=" + differentialLock + ", plate=" + plate + ", engine=" + engine
				+ ", traction=" + traction + ", client=" + client.getName() + "]";
	}
}
