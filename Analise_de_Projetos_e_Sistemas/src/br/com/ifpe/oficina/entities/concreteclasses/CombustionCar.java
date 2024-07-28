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

	public static final class CombustionCarBuilder {
		private Client client;
		private String traction;
		private String engine;
		private String plate;

		private CombustionCarBuilder() {}

		public static CombustionCarBuilder aCombustionCar() {
			return new CombustionCarBuilder();
		}

		public CombustionCarBuilder client(Client client) {
			this.client = client;
			return this;
		}

		public CombustionCarBuilder traction(String traction) {
			this.traction = traction;
			return this;
		}

		public CombustionCarBuilder engine(String engine) {
			this.engine = engine;
			return this;
		}

		public CombustionCarBuilder plate(String plate) {
			this.plate = plate;
			return this;
		}

		public CombustionCar build() {
			CombustionCar combustionCar = new CombustionCar();
			combustionCar.setClient(client);
			combustionCar.setTraction(traction);
			combustionCar.setPlate(plate);
			return combustionCar;
		}
	}
}
