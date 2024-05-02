package br.com.ifpe.oficina.entities.concreteclasses;

import java.util.List;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.person.Employee;

public class WorkshopManager {

	private List<Car> CarList;
	private List<Employee> employeeList;
	private String workshopName;
	private String cnpj;
	private String address;

	public WorkshopManager(
			List<Car> CarList,
			List<Employee> employeeList,
			String workshopName,
			String cnpj,
			String address) {
		
		super();
		this.CarList = CarList;
		this.employeeList = employeeList;
		this.workshopName = workshopName;
		this.cnpj = cnpj;
		this.address = address;
	}
	
	private final WorkshopManager instance = new WorkshopManager(
			getCarList(),
			getEmployeeList(),
			getWorkshopName(),
			getCnpj(),
			getAddress());
	
	public WorkshopManager getInstance() {
		return instance;
	}

	public List<Car> getCarList() {
		return CarList;
	}

	public void setCarList(List<Car> CarList) {
		this.CarList = CarList;
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
