package br.com.ifpe.oficina.entities.concreteclasses;

import br.com.ifpe.oficina.entities.abstractclasses.Person;

public class Client extends Person {
	
	protected boolean afiliados;
	
	protected Client(String nome, int cpf, int idade, String email, boolean afiliados) {
		super(nome, cpf, idade, email);
		this.afiliados = afiliados;
	}

	public static class ClientBuilder{
		protected String nome;
		protected int cpf;
		protected int idade;
		protected String email;
		protected boolean afiliados;
		
		public ClientBuilder nome(String nome) {
			this.nome = nome;
			return this;
		}
		
		public ClientBuilder cpf(int cpf) {
			this.cpf = cpf;
			return this;
		}
		
		public ClientBuilder idade(int idade) {
			this.idade = idade;
			return this;
		}
		
		public ClientBuilder email(String email) {
			this.email = email;
			return this;
		}
		
		public ClientBuilder afiliados(boolean afiliados) {
			this.afiliados = afiliados;
			return this;
		}
		
		public Client build() {
			return new Client(nome, cpf, idade, email, afiliados);	
		}
	}

	@Override
	public String toString() {
		return "Client [afiliados=" + afiliados + ", nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", email="
				+ email + "]";
	}
}

