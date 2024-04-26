package br.com.ifpe.oficina.main;

import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.entities.concreteclasses.WorkshopManager;

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
		
		WorkshopManager workshopManager = new WorkshopManager.WorkshopManagerBuilder()
				.cnpj("ffssdfsfs")
				.workshopName("teste")
				.address("Rua come cu")
				.build();
		System.out.println(workshopManager.toString());
	}
}
