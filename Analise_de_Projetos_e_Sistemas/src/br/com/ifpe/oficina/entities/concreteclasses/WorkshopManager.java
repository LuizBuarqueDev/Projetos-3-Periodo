package br.com.ifpe.oficina.entities.concreteclasses;

import java.util.List;

import br.com.ifpe.oficina.entities.concreteclasses.person.Employee;

public class WorkshopManager {

	private List<Services> servicesList;
	private List<Employee> employeeList;
	private String workshopName;
	private String cnpj;
	private String address;

	public WorkshopManager(
			List<Services> servicesList,
			List<Employee> employeeList,
			String workshopName,
			String cnpj,
			String address) {
		
		super();
		this.servicesList = servicesList;
		this.employeeList = employeeList;
		this.workshopName = workshopName;
		this.cnpj = cnpj;
		this.address = address;
	}
	
	private final WorkshopManager instance = new WorkshopManager(
			getServicesList(),
			getEmployeeList(),
			getWorkshopName(),
			getCnpj(),
			getAddress());
	
	public WorkshopManager getInstance() {
		return instance;
	}

	public List<Services> getServicesList() {
		return servicesList;
	}

	public void setServicesList(List<Services> servicesList) {
		this.servicesList = servicesList;
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
