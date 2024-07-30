package br.com.ifpe.oficina.entities.concreteclasses;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.abstractclasses.Person;

public final class Client extends Person {

	private Car car;

	private Client(String name, String cpf, int age, String email, Car car) {
		super(name, cpf, age, email);
		this.car = car;
	}

	public static ClientBuilder ClientBuilder() {
		return new ClientBuilder();
	}

	public static class ClientBuilder {
		private String name;
		private String cpf;
		private int age;
		private String email;
		private Car car;

		public ClientBuilder name(String name) {
			this.name = name;
			return this;
		}

		public ClientBuilder cpf(String cpf) {
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

		public ClientBuilder car(Car car) {
			this.car = car;
			return this;
		}

		public Client build() {
			return new Client(name, cpf, age, email, car);
		}
	}
	
	@Override
	public String toString() {
		return "Client [name=" + name + ", cpf=" + cpf + ", age=" + age
				+ ", email=" + email + "]";
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
