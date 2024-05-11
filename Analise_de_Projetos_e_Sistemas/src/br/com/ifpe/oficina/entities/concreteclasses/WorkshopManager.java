package br.com.ifpe.oficina.entities.concreteclasses;

import java.util.List;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.person.Employee;

public class WorkshopManager {

	private static final WorkshopManager instance = new WorkshopManager();
	private List<Car> carList;
	private List<Employee> employeeList;
	private String workshopName;
	private String cnpj;
	private String address;
	
	public static WorkshopManager getInstance() {
		return instance;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public String getWorkshopName() {
		return workshopName;
	}

	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
