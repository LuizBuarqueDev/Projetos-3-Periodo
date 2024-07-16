package br.com.ifpe.oficina.apresentation;

import java.util.Scanner;

import br.com.ifpe.oficina.services.controllers.ClientController;

public class GUIClient {
	Scanner scanner = new Scanner(System.in);
	String cpf = "";
	ClientController clientController = ClientController.getInstance();

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
					clientController.viewAll().stream().forEach(System.out::println);
					break;

				default:
					System.out.println("O valor " + choice + "é invalido");
					break;
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void create() {

	}

	private void read() {
		System.out.println("Cpf: ");
		cpf = scanner.nextLine();
		System.out.println(clientController.read(cpf));
	}

	private void update() {


	}

	private void delete() {
		System.out.println("Cpf: ");
		cpf = scanner.nextLine();
		clientController.delete(cpf);
		System.out.println("Cliente deletado");
	}
}