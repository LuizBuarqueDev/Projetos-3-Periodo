package br.com.ifpe.oficina.main;
import br.com.ifpe.oficina.entities.concreteclasses.person.Client;

public class Main {
	public static void main(String[] args) {
		
		Client client = Client.ClientBuilder()
				.age(25)
				.affiliate(false)
				.cpf(111248547)
				.email("zezin@gmail.com")
				.name("zezin")
				.build();
		System.out.println(client.toString());
	}
}
