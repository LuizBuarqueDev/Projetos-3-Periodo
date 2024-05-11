package br.com.ifpe.oficina.entities.concreteclasses.person;

import br.com.ifpe.oficina.entities.abstractclasses.Person;

public final class Employee extends Person {
	private String admissionDate;

	public Employee(String name, int cpf, int age, String email, String admissionDate) {
		super(name, cpf, age, email);
		this.admissionDate = admissionDate;
	}

	public String getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
}
