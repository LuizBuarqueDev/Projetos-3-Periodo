package br.com.ifpe.oficina.main;
import java.util.ArrayList;

import br.com.ifpe.oficina.entities.concreteclasses.car.EletricCar;
import br.com.ifpe.oficina.entities.concreteclasses.factories.EletricCarFactory;
import br.com.ifpe.oficina.entities.concreteclasses.person.Client;

public class Main {
	public static void main(String[] args) {
		
		ArrayList<Client> arrayList = new ArrayList<Client>();
		
		
		for (int i = 0; i < 10; i++) {
			
			EletricCar eletricCar = (EletricCar) EletricCarFactory.eletricCarFactory().createCar();
			Client client = Client.ClientBuilder()
					.age(25+ i)
					.affiliate(false)
					.cpf(111248547 + i)
					.email("zezin@gmail.com" + i)
					.name("zezin" + i)
					.car(eletricCar)
					.build();

			eletricCar.setClient(client);
			eletricCar.setBatteryCapacity(10000 + i);
			eletricCar.setPlate("ABC-"+ i);
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
				" ; \nCarro: " + 
				"Motor: "+ t.getCar().getEngine() + 
				" ; Placa: " + t.getCar().getPlate() +
				" ; Tração: " + t.getCar().getTraction() +
				" ; Cliente: " + t.getCar().getClient().getName() + 
				" ; Bateria: " + ((EletricCar) t.getCar()).getBatteryCapacity() +
				"\n-----------------------------------------------------------"
				));
	}
}
