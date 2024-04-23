package br.com.ifpe.oficina.entities.abstractclasses;

public class Person {
	private String nome;
	private int cpf;
	private int idade;
	private String email;

	private Person(String nome, int cpf, int idade, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.email = email;
	}

	public static class PersonBuilder {
		private String nome;
		private int cpf;
		private int idade;
		private String email;

		public PersonBuilder nome(String nome) {
			this.nome = nome;
			return this;
		}

		public PersonBuilder cpf(int cpf) {
			this.cpf = cpf;
			return this;
		}

		public PersonBuilder nome(int idade) {
			this.idade = idade;
			return this;
		}

		public PersonBuilder email(String email) {
			this.email = email;
			return this;
		}

		public Person buid() {
			return new Person(nome, cpf, idade, email);
		}
	}
}
