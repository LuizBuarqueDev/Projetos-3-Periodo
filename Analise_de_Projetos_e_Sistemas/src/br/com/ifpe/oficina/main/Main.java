package br.com.ifpe.oficina.main;
import java.util.ArrayList;
import java.util.Random;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.car.EletricCar;
import br.com.ifpe.oficina.entities.concreteclasses.car.JeepCar;
import br.com.ifpe.oficina.entities.concreteclasses.factories.EletricCarFactory;
import br.com.ifpe.oficina.entities.concreteclasses.factories.JeepFactory;
import br.com.ifpe.oficina.entities.concreteclasses.factories.SilkFactory;
import br.com.ifpe.oficina.entities.concreteclasses.person.Client;

public class Main {
	public static void main(String[] args) {
		Random random = new Random();
		ArrayList<Client> arrayList = new ArrayList<Client>();
		
		
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
			
			arrayList.add(client);
		}
		
		EletricCar.create();
		
		arrayList.stream().forEach(t -> System.out.println(
				"Nome: " + t.getName() + 
				" ; Idade: " + t.getAge() +
				" ; CPF: " + t.getCpf() +
				" ; Email: " + t.getEmail() +
				" ; Afiliado: " + t.isAffiliate() +
				" ; \nCarro: " + t.getCar().toString() +
				"\n---------------------------------------------------------"
				));
		
		EletricCar fjiujdfd = EletricCar.create();
	}
}
