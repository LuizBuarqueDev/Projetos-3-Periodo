package br.com.ifpe.oficina.apresentation;

import java.util.Scanner;

import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.services.controllers.CarController;

public class GUICar {
	
	String plate = "";
	Scanner scanner = new Scanner(System.in);
	CarController carController = CarController.getInstance();
	
	public void CarGUI() {



		while (true) {
			try {

				System.out.println("\n[1]-create\n[2]-update\n[3]-read\n[4]-delete\n[5]-view all");
				String choice = scanner.nextLine();

				switch (choice) {

				case "1": // Create
					create();
					break;

				case "2": // Update : tração, cliente
					update();
					break;

				case "3": // Read
					read();
					break;

				case "4": // Delete
					delete();
					break;

				case "5": // All
					carController.viewAll().stream().forEach(System.out::println);
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
		System.out.print("Digite a placa: ");
		plate = scanner.nextLine();
		System.out.println("Criando o carro...");
		System.out.println("Nova placa: ");
		String newPlate = scanner.nextLine();
		System.out.println("Tração: ");
		String newTraction = scanner.nextLine();
		System.out.println("Nova placa: ");
		Client newClient = null;
	}
	
	private void update() {
		System.out.print("Digite a placa: ");
		plate = scanner.nextLine();
		System.out.println(carController.read(plate));
		System.out.println("Atualizando carro...");
		System.out.println("Tração: ");
		String traction = scanner.nextLine();
		carController.update(plate, traction);
	}
	
	private void read() {
		System.out.print("Digite a placa: ");
		plate = scanner.nextLine();
		System.out.println(carController.read(plate));
	}
	
	private void delete() {
		System.out.print("Digite a placa: ");
		plate = scanner.nextLine();
		carController.delete(plate);
		System.out.println("Carro removido");
	}
}
