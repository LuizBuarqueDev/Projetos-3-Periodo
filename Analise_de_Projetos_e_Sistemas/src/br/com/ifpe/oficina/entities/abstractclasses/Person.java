package br.com.ifpe.oficina.entities.abstractclasses;

public abstract class Person {
	protected String nome;
	protected int cpf;
	protected int idade;
	protected String email;

	static abstract class PersonBuilder {
		protected String nome;
		protected int cpf;
		protected int idade;
		protected String email;

		public PersonBuilder nome(String nome) {
			this.nome = nome;
			return this;

		}
		
		public PersonBuilder cpf(int cpf) {
			this.cpf = cpf;
			return this;

		}
		
		public PersonBuilder idade(int idade) {
			this.idade = idade;
			return this;

		}
		
		public PersonBuilder email(String email) {
			this.email = email;
			return this;

		}
		
	    public abstract Person build();
	}
}
