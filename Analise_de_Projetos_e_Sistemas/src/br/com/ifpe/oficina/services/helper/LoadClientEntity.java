package br.com.ifpe.oficina.services.helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.entities.concreteclasses.Employee;
import br.com.ifpe.oficina.entities.concreteclasses.JeepCar;
import br.com.ifpe.oficina.entities.concreteclasses.MechanicManager;
import br.com.ifpe.oficina.services.factories.EletricCarFactory;
import br.com.ifpe.oficina.services.factories.JeepFactory;
import br.com.ifpe.oficina.services.factories.SilkFactory;

public class LoadClientEntity {
	
	private static final LoadClientEntity instance = new LoadClientEntity();
	
	public static LoadClientEntity getinstance() {
		return instance;
	}
	
	Random random = new Random();
	
    MechanicManager mechanicManager = MechanicManager.getInstance();

    ArrayList<Client> clientList = new ArrayList<>();
    ArrayList<Employee> employeeList = new ArrayList<>();
    ArrayList<Car> carList = new ArrayList<>();

    public void createRandomData() {

        mechanicManager.setCarList(carList);
        mechanicManager.setEmployeeList(employeeList);
        mechanicManager.setCnpj("46.379 400 0001 50");
        mechanicManager.setmechanicName("Oficina Tião Matador de Porco");
        mechanicManager.setAddress("Brasil, Palmares-PE, Bairro Sem Praça, Rua Quase Mudo, N:225");

        generateClients(100, clientList);
        generateCars(100, clientList);
        generateEmployees(15, clientList, employeeList);
    }

    private void generateClients(int quantity, ArrayList<Client> clientList) {
        Set<Integer> usedCpfs = new HashSet<>();

        for (int i = 0; i < quantity; i++) {
            int cpf;
            do {
                cpf = 111248547 + i;
            } while (!usedCpfs.add(cpf));
            Client client = Client.ClientBuilder()
                    .age(20 + i)
                    .affiliate(i % 3 == 0)
                    .cpf(cpf)
                    .email("cliente" + i + "@gmail.com")
                    .name("cliente" + i)
                    .build();

            clientList.add(client);
        }
    }

    private void generateCars(int quantity, ArrayList<Client> clientList) {
        for (int i = 0; i < quantity; i++) {
            int key = random.nextInt(3);
            Client client = clientList.get(i);

            switch (key) {
                case 0: {
                    Car car = EletricCarFactory.eletricCarFactory().createCar();
                    car.setClient(client);
                    car.setPlate("ABC-" + i);
                    car.setTraction("4x2");
                    carList.add(car);
                    client.setCar(car);
                    break;
                }
                case 1: {
                    Car car = JeepFactory.jeepFactory().createCar();
                    car.setClient(client);
                    car.setPlate("DEF-" + i);
                    car.setTraction("4x4");
                    ((JeepCar) car).setDifferentialLock(false);

                    carList.add(car);
                    client.setCar(car);
                    break;
                }
                case 2: {
                    Car car = SilkFactory.silkFactory().createCar();
                    car.setClient(client);
                    car.setPlate("GHI-" + i);
                    car.setTraction("4x2");

                    carList.add(car);
                    client.setCar(car);
                    break;
                }
                default:
                    System.out.println("Unexpected value: " + key);
            }
        }
    }

    private void generateEmployees(int quantity, ArrayList<Client> clientList, ArrayList<Employee> employeeList) {
        Set<Integer> usedCpfs = new HashSet<>();

        for(int r = 0; r < quantity; r++) {
            int cpf;
            do {
                cpf = 211248547 + r;
            } while (!usedCpfs.add(cpf));

            Employee employee = Employee.EmployeeBuilder()
                    .age(40 - r)
                    .cpf(cpf)
                    .email("funcionario" + r + "@gmail.com")
                    .name("funcionario" + r)
                    .admissionDate(random.nextInt(1, 28) + "/" + random.nextInt(1, 13) + "/" + random.nextInt(2000, 2024))
                    .build();

            employeeList.add(employee);
        }
    }
}