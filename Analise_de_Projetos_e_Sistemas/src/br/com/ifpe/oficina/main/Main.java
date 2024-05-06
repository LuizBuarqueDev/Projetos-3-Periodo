package br.com.ifpe.oficina.main;
import java.util.ArrayList;
import java.util.Random;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.car.EletricCar;
import br.com.ifpe.oficina.entities.concreteclasses.factories.EletricCarFactory;
import br.com.ifpe.oficina.entities.concreteclasses.person.Client;

public class Main {
	public static void main(String[] args) {
		Random random = new Random();
		ArrayList<Client> arrayList = new ArrayList<Client>();
		
		
		for (int i = 0; i < 10; i++) {
			int key = random.nextInt(3);
			
			Car eletricCar = EletricCarFactory.eletricCarFactory().createCar();
			Client client = Client.ClientBuilder()
					.age(25+ i)
					.affiliate(false)
					.cpf(111248547 + i)
					.email("zezin@gmail.com" + i)
					.name("zezin" + i)
					.car(eletricCar)
					.build();
			
			switch (key) {
			case 0: {
			}
			case 1:{
				
			}
			case 2: {
				
			}
			default:
				System.out.println("Unexpected value: " + key);
			}

			eletricCar.setClient(client);
			((EletricCar) eletricCar).setBatteryCapacity(10000 + i);
			eletricCar.setPlate("ABC-" + i);
			eletricCar.setClient(client);
			eletricCar.setTraction("4x2");

			arrayList.add(client);
		}
		arrayList.stream().forEach(t -> System.out.println(
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
