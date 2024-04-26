package br.com.ifpe.oficina.entities.abstractclasses;

public abstract class Person {
	protected String name;
	protected int cpf;
	protected int age;
	protected String email;
	
	protected Person(String name, int cpf, int age, String email) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.age = age;
		this.email = email;
	}
}
