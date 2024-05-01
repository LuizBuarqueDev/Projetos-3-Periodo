package br.com.ifpe.oficina.entities.concreteclasses;

import br.com.ifpe.oficina.entities.abstractclasses.Person;

public final class Employee extends Person {
	protected String admissionDate;

	public Employee(String name, int cpf, int age, String email, String admissionDate) {
		super(name, cpf, age, email);
		this.admissionDate = admissionDate;
	}
}
