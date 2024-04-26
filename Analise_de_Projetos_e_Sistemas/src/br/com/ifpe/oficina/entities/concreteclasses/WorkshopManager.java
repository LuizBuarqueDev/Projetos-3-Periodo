package br.com.ifpe.oficina.entities.concreteclasses;

import java.util.List;

public class WorkshopManager {

	private List<Services> servicesList;
	private List<Employee> employeeList;
	private String workshopName;
	private String cnpj;
	private String address;

	private WorkshopManager(List<Services> servicesList, List<Employee> employeeList, String workshopName, String cnpj,
			String address) {
		super();
		this.servicesList = servicesList;
		this.employeeList = employeeList;
		this.workshopName = workshopName;
		this.cnpj = cnpj;
		this.address = address;
	}

	public static class WorkshopManagerBuilder {

		private List<Services> servicesList;
		private List<Employee> employeeList;
		private String workshopName;
		private String cnpj;
		private String address;
		
		public WorkshopManagerBuilder servicesList(List<Services> servicesList) {
			this.servicesList = servicesList;
			return this;
		}
		
		public WorkshopManagerBuilder employeeList(List<Employee> employeeList) {
			this.employeeList = employeeList;
			return this;
		}
		
		public WorkshopManagerBuilder workshopName(String workshopName) {
			this.workshopName = workshopName;
			return this;
		}
		
		public WorkshopManagerBuilder cnpj(String cnpj) {
			this.cnpj = cnpj;
			return this;
		}
		
		public WorkshopManagerBuilder address(String address) {
			this.address = address;
			return this;
		}
		
		public WorkshopManager build() {
			return new WorkshopManager(servicesList, employeeList, workshopName, cnpj, address);
		}
	}

	@Override
	public String toString() {
		return "WorkshopManager [servicesList=" + servicesList + ", employeeList=" + employeeList + ", workshopName="
				+ workshopName + ", cnpj=" + cnpj + ", address=" + address + "]";
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
