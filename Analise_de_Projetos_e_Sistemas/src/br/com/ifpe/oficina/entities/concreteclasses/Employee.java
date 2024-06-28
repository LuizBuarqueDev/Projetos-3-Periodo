package br.com.ifpe.oficina.entities.concreteclasses;

import br.com.ifpe.oficina.entities.abstractclasses.Person;

public final class Employee extends Person {
	private String admissionDate;

	public Employee(String name, int cpf, int age, String email, String admissionDate) {
		super(name, cpf, age, email);
		this.admissionDate = admissionDate;
	}

	public static EmployeeBuilder EmployeeBuilder() {
		return new EmployeeBuilder();
	}

	public static class EmployeeBuilder {
		private String name;
		private int cpf;
		private int age;
		private String email;
		private String admissionDate;

		public EmployeeBuilder name(String name) {
			this.name = name;
			return this;
		}

		public EmployeeBuilder cpf(int cpf) {
			this.cpf = cpf;
			return this;
		}

		public EmployeeBuilder age(int age) {
			this.age = age;
			return this;
		}

		public EmployeeBuilder email(String email) {
			this.email = email;
			return this;
		}
		
		public EmployeeBuilder admissionDate(String admissionDate) {
			this.admissionDate = admissionDate;
			return this;
		}

		public Employee build() {
			return new Employee(name, cpf, age, email, admissionDate);
		}
	}
	
	@Override
	public String toString() {
		return "Employee [admissionDate=" + admissionDate + ", name=" + name + ", cpf=" + cpf + ", age=" + age
				+ ", email=" + email + "]";
	}

	public String getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
}
