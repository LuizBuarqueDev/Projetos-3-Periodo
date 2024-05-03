package br.com.ifpe.oficina.entities.concreteclasses.car;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.person.Client;

public class EletricCar extends Car{
	
	private int batteryCapacity;

	public EletricCar(String plate, String traction, Client client, int batteryCapacity) {
		super(plate, traction, client);
		this.batteryCapacity = batteryCapacity;
	}
}
