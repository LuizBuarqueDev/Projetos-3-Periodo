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

	public static final class EletricCarBuilder {
		private String plate;
		private String engine;
		private String traction;
		private Client client;

		private EletricCarBuilder() {}

		public static EletricCarBuilder anEletricCar() {
			return new EletricCarBuilder();
		}

		public EletricCarBuilder plate(String plate) {
			this.plate = plate;
			return this;
		}

		public EletricCarBuilder engine(String engine) {
			this.engine = engine;
			return this;
		}

		public EletricCarBuilder traction(String traction) {
			this.traction = traction;
			return this;
		}

		public EletricCarBuilder client(Client client) {
			this.client = client;
			return this;
		}

		public EletricCar build() {
			EletricCar eletricCar = new EletricCar();
			eletricCar.setPlate(plate);
			eletricCar.setTraction(traction);
			eletricCar.setClient(client);
			eletricCar.engine = this.engine;
			return eletricCar;
		}
	}
}
