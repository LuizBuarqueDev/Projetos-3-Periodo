package br.com.ifpe.oficina.entities.concreteclasses;

import java.util.List;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.abstractclasses.Person;
import br.com.ifpe.oficina.interfaces.IWorkshopManeger;

public class WorkshopManager implements IWorkshopManeger {

	private static final WorkshopManager instance = new WorkshopManager();
	private List<Car> carList;
	private List<Employee> employeeList;
	private String workshopName;
	private String cnpj;
	private String address;

	public static WorkshopManager getInstance() {
		return instance;
	}

	public Car searchCar(String plate) {
		for (Car car : getCarList()) {
			if (car.getPlate().equals(plate)) {
				System.out.println("Carro encontrado: " + car.toString());
				return car;
			}
		}
		return null;
	}

	public Person searchPerson(int cpf) {
		for (Employee employee : getEmployeeList()) {
			if (employee.getCpf() == cpf) {
				return employee;
			}
		}

		for (Car car : getCarList()) {
			if (car.getClient().getCpf() == cpf) {
				return car.getClient();
			}
		}
		return null;
	}

	@Override
	public String viewAll() {
		String result = "";
		// TODO Auto-generated method stub
		result += WorkshopManager.getInstance().getWorkshopName() + "\n" + WorkshopManager.getInstance().getAddress()
				+ "\n" + WorkshopManager.getInstance().getCnpj()
				+ "\n------------------------------------------------------";

		for (Car car : carList) {
			result += car.toString() + "\n";
		}

		result += "\n**********************************\n";

		for (Employee employee : employeeList) {
			result += employee.toString() + "\n";
		}
		return result;
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
