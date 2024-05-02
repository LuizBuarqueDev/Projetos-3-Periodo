package br.com.ifpe.oficina.main;

import br.com.ifpe.oficina.entities.concreteclasses.car.EletricCarFactory;
import br.com.ifpe.oficina.entities.concreteclasses.person.Client;

public class Main {
	public static void main(String[] args) {
		
		Client client = new Client.ClientBuilder()
				.age(25)
				.affiliate(false)
				.cpf(111248547)
				.email("zezin@gmail.com")
				.name("zezin")
				.build();
		System.out.println(client.toString());
		
		EletricCarFactory carFactory = (EletricCarFactory) EletricCarFactory.getInstance().createCar("ABC-123", "DEF-456", 2014);
		System.out.println(carFactory.toString());
	}
}
