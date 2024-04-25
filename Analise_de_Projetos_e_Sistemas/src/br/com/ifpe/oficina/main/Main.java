package br.com.ifpe.oficina.main;

import br.com.ifpe.oficina.entities.concreteclasses.Client;

public class Main {
	public static void main(String[] args) {
		
		Client client = new Client.ClientBuilder()
				.idade(25)
				.afiliados(false)
				.cpf(111248547)
				.email("zezin@gmail.com")
				.nome("zezin")
				.build();
		System.out.println(client.toString());
	}
}
