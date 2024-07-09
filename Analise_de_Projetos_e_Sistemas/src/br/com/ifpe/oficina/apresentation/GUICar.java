package br.com.ifpe.oficina.apresentation;

import java.util.Scanner;

import br.com.ifpe.oficina.business.CarController;
import br.com.ifpe.oficina.entities.concreteclasses.Client;

public class GUICar {
	public void CarGUI() {

		String plate = "";
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		CarController carController = CarController.createController();

		while (true) {

			try {

				System.out.println("\n[1]-create\n[2]-update\n[3]-read\n[4]-delete\n[5]-view all");
				String choice = scanner.nextLine();

				switch (choice) {

				case "1": // Create
					System.out.print("Digite a placa: ");
					plate = scanner.nextLine();
					System.out.println("Criando o carro...");
					break;

				case "2": // Update : tração, cliente 
					System.out.print("Digite a placa: ");
					plate = scanner.nextLine();
					System.out.println(carController.read(plate));
					System.out.println("Atualizando carro...");
					System.out.println("Tração: ");
					String traction = scanner.nextLine();
					Client client = Client.ClientBuilder().build();
					carController.update(plate, traction, client);

					break;

				case "3": // Read
					System.out.print("Digite a placa: ");
					plate = scanner.nextLine();
					System.out.println(carController.read(plate));
					break;

				case "4": // Delete
					System.out.print("Digite a placa: ");
					plate = scanner.nextLine();
					carController.delete(plate);
					System.out.println("Carro removido");
					break;

				case "5": // All
					System.out.println(carController.viewAll());
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
}
