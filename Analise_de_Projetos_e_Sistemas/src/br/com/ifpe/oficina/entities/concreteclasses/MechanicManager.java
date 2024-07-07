package br.com.ifpe.oficina.entities.concreteclasses;

import java.util.List;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.abstractclasses.Person;
import br.com.ifpe.oficina.interfaces.IMechanicManager;

public class MechanicManager implements IMechanicManager {

	private static final MechanicManager instance = new MechanicManager();
	private List<Car> carList;
	private List<Employee> employeeList;
	private String mechanicName;
	private String cnpj;
	private String address;

	public static MechanicManager getInstance() {
		return instance;
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
		result += MechanicManager.getInstance().getmechanicName() + "\n" + MechanicManager.getInstance().getAddress()
				+ "\n" + MechanicManager.getInstance().getCnpj()
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

	public String getmechanicName() {
		return mechanicName;
	}

	public void setmechanicName(String mechanicName) {
		this.mechanicName = mechanicName;
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
