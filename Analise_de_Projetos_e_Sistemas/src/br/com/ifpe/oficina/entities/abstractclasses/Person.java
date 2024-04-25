package br.com.ifpe.oficina.entities.abstractclasses;

public abstract class Person {
	protected String nome;
	protected int cpf;
	protected int idade;
	protected String email;
	
	protected Person(String nome, int cpf, int idade, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.email = email;
	}
}
