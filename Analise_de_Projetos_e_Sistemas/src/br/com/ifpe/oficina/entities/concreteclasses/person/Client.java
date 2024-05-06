package br.com.ifpe.oficina.entities.concreteclasses.person;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.abstractclasses.Person;

public final class Client extends Person {

	private boolean affiliate;
	private Car car;

	private Client(String name, int cpf, int age, String email, boolean affiliate, Car car) {
		super(name, cpf, age, email);
		this.affiliate = affiliate;
		this.car = car;
	}

	public static ClientBuilder ClientBuilder() {
		return new ClientBuilder();
	}

	public static class ClientBuilder {
		private String name;
		private int cpf;
		private int age;
		private String email;
		private boolean affiliate;
		private Car car;

		public ClientBuilder name(String name) {
			this.name = name;
			return this;
		}

		public ClientBuilder cpf(int cpf) {
			this.cpf = cpf;
			return this;
		}

		public ClientBuilder age(int age) {
			this.age = age;
			return this;
		}

		public ClientBuilder email(String email) {
			this.email = email;
			return this;
		}

		public ClientBuilder affiliate(boolean affiliate) {
			this.affiliate = affiliate;
			return this;
		}

		public ClientBuilder car(Car car) {
			this.car = car;
			return this;
		}

		public Client build() {
			return new Client(name, cpf, age, email, affiliate, car);
		}
	}
	
	@Override
	public String toString() {
		return "Client [affiliate=" + affiliate + ", car=" + car + ", name=" + name + ", cpf=" + cpf + ", age=" + age
				+ ", email=" + email + "]";
	}

	public boolean isAffiliate() {
		return affiliate;
	}

	public void setAffiliate(boolean affiliate) {
		this.affiliate = affiliate;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
