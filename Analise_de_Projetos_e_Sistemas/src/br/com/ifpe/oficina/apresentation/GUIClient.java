package br.com.ifpe.oficina.apresentation;

import java.util.Scanner;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.services.controllers.ClientController;

public class GUIClient {

	private static final GUIClient instance = new GUIClient();

	Scanner scanner = new Scanner(System.in);
	String cpf = "";
	ClientController clientController = ClientController.getInstance();

	private GUIClient() {}

	public static GUIClient getInstace() {
		return instance;
	}

	public void clientGUI() {
		while (true) {
			try {
				System.out.println("\n[1]-create\n[2]-update\n[3]-read\n[4]-delete\n[5]-view all");
				String choice = scanner.nextLine();

				switch (choice) {
					case "1": // Create
						create();

						break;
					case "2": // Update
						update();

						break;
					case "3": // Read
						read();

						break;
					case "4": // Delete
						delete();
						break;
					case "5": // All
						clientController.viewAll().forEach(System.out::println);
						break;

					default:
						System.out.println("O valor '" + choice + "' é invalido");
						break;
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void create() {
		System.out.println("Idade: ");
		String age = scanner.nextLine();

		System.out.println("Cpf: ");
		String cpf = scanner.nextLine();

		System.out.println("E-mail: ");
		String email = scanner.nextLine();

		System.out.println("Nome: ");
		String name = scanner.nextLine();

		clientController.create(name, age, cpf, email);
		System.out.println("Cliente criado com sucesso");

		Car tempCar = GUICar.getInstace().createOnlyCar();
		System.out.println("Carro criado");
		System.out.println(tempCar.toString());
	}

	public Client createOnlyClient() {
		System.out.println("Idade: ");

		try {
			System.out.println("Idade: ");
			int age = Integer.parseInt(scanner.nextLine());

			System.out.println("Cpf: ");
			String cpf = scanner.nextLine();

			System.out.println("E-mail: ");
			String email = scanner.nextLine();

			System.out.println("Nome: ");
			String name = scanner.nextLine();

			return Client.ClientBuilder()
					.age(age)
					.cpf(cpf)
					.email(email)
					.name(name)
					.build();
		} catch (NumberFormatException e) {
			throw new RuntimeException("A idade não é um inteiro");
		}

	}

	private void read() {
		System.out.println("Cpf: ");
		cpf = scanner.nextLine();
		System.out.println(clientController.read(cpf));
	}

	private void update() {
		// implementação do método de atualização
	}

	private void delete() {
		System.out.println("Cpf: ");
		cpf = scanner.nextLine();
		clientController.delete(cpf);
		System.out.println("Cliente deletado");
	}

	public void createOnlyCar() {
		GUICar.getInstace().createOnlyCar();
	}
}