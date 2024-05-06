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
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", cpf=" + cpf + ", age=" + age + ", email=" + email + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
