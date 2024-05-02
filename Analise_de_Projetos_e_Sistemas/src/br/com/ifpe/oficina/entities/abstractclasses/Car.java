package br.com.ifpe.oficina.entities.abstractclasses;

public abstract class Car {
	protected String plate;
	protected String chassis;
	protected int age;
	protected String engine;
	
	protected Car() {
		// TODO Auto-generated constructor stub
	}
	
	protected Car(String plate, String chassis, int age) {
		super();
		this.plate = plate;
		this.chassis = chassis;
		this.age = age;
		this.engine = null;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getChassis() {
		return chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}
}
