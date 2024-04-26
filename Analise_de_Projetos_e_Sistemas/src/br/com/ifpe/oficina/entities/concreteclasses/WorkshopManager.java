package br.com.ifpe.oficina.entities.concreteclasses;

import java.util.List;

public class WorkshopManager {

	private List<Services> servicesList;
	private List<employees> employeeList;
	private String workshopName;
	private String cnpj;
	private String address;

	private WorkshopManager(List<Services> servicesList, List<employees> employeeList, String workshopName, String cnpj,
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
		private List<employees> employeeList;
		private String workshopName;
		private String cnpj;
		private String address;
	}
}
