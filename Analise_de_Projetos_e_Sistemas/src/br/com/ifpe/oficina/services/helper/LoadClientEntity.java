package br.com.ifpe.oficina.services.helper;

import java.util.ArrayList;
import java.util.Random;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.WorkshopManager;
import br.com.ifpe.oficina.entities.concreteclasses.car.EletricCar;
import br.com.ifpe.oficina.entities.concreteclasses.car.JeepCar;
import br.com.ifpe.oficina.entities.concreteclasses.person.Client;
import br.com.ifpe.oficina.entities.concreteclasses.person.Employee;
import br.com.ifpe.oficina.services.factories.EletricCarFactory;
import br.com.ifpe.oficina.services.factories.JeepFactory;
import br.com.ifpe.oficina.services.factories.SilkFactory;

public class LoadClientEntity {
	
	public void createRamdomDate() {
		Random random = new Random();
		
		ArrayList<Client> clientList = new ArrayList<Client>();
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		
		ArrayList<Car> carList = new ArrayList<Car>();
		
	 WorkshopManager workshopManager = WorkshopManager.getInstance();
	 workshopManager.setCarList(carList);
	 workshopManager.setEmployeeList(employeeList);
	 workshopManager.setCnpj("46.379 400 0001 50"); 
	 workshopManager.setWorkshopName("Ofina Tião Matador de Porco");
	 workshopManager.setAddress("Brasil, Palmares-PE, Bairro Sem Praça, Rua Quase Mudo, N:225");
		
		for (int i = 0; i < 10; i++) {
			int key = random.nextInt(3);
			
			Client client = Client.ClientBuilder()
					.age(25+ i)
					.affiliate(false)
					.cpf(111248547 + i)
					.email("zezin@gmail.com" + i)
					.name("zezin" + i)
					.build();
			
			switch (key) {
			case 0: {
				Car car = EletricCarFactory.eletricCarFactory().createCar();
				car.setClient(client);
				((EletricCar) car).setBatteryCapacity(10000 + i);
				car.setPlate("ABC-" + i);
				car.setClient(client);
				car.setTraction("4x2");
				
				client.setCar(car);
				break;
			}
			case 1:{
				Car car = JeepFactory.jeepFactory().createCar();
				car.setClient(client);
				car.setPlate("DEF-" + i);
				car.setClient(client);
				car.setTraction("4x4");
				((JeepCar)car).setDifferentialLock(false);
				
				client.setCar(car);
				break;
				
			}
			case 2: {
				Car car = SilkFactory.silkFactory().createCar();
				car.setClient(client);
				car.setPlate("GHI-" + i);
				car.setClient(client);
				car.setTraction("4x2");
				
				client.setCar(car);
				break;
				
			}
			default:
				System.out.println("Unexpected value: " + key);
			}
			
			System.out.println("Key: " + key);
			
			clientList.add(client);
		}
		
		EletricCar.create();
		
		clientList.stream().forEach(t -> System.out.println(
				"Nome: " + t.getName() + 
				" ; Idade: " + t.getAge() +
				" ; CPF: " + t.getCpf() +
				" ; Email: " + t.getEmail() +
				" ; Afiliado: " + t.isAffiliate() +
				" ; \nCarro: " + t.getCar().toString() +
				"\n---------------------------------------------------------"
				));
	}
}
