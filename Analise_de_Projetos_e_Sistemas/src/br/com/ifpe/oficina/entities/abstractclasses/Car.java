package br.com.ifpe.oficina.entities.abstractclasses;

import br.com.ifpe.oficina.entities.concreteclasses.Client;

public abstract class Car implements Cloneable {
	
	protected String plate;
	protected String engine;
	protected String traction;
	protected Client client;
	
	public Car() {
	}
	
	protected Car(String plate, String traction, Client client) {
		super();
		this.plate = plate;
		this.traction = traction;
		this.client = client;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getTraction() {
		return traction;
	}

	public void setTraction(String traction) {
		this.traction = traction;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Car{" +
				"plate='" + plate + '\'' +
				", engine='" + engine + '\'' +
				", traction='" + traction + '\'' +
				", client=" + client.getName() +
				'}';
	}
	public abstract double getprice();

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
