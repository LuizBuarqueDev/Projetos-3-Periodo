package br.com.ifpe.oficina.entities.concreteclasses;

import br.com.ifpe.oficina.entities.abstractclasses.Person;

public class Client extends Person {

	protected boolean affiliate;

	protected Client(String name, int cpf, int age, String email, boolean affiliate) {
		super(name, cpf, age, email);
		this.affiliate = affiliate;
	}

	public static class ClientBuilder {
		protected String name;
		protected int cpf;
		protected int age;
		protected String email;
		protected boolean affiliate;

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

		public Client build() {
			return new Client(name, cpf, age, email, affiliate);
		}
	}

	@Override
	public String toString() {
		return "Client [affiliate=" + affiliate + ", name=" + name + ", cpf=" + cpf + ", age=" + age + ", email="
				+ email + "]";
	}
}
