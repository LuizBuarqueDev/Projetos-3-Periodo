package br.com.ifpe.oficina.apresentation;

import java.util.Scanner;

import br.com.ifpe.oficina.business.CarController;
import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.MechanicManager;
import br.com.ifpe.oficina.entities.concreteclasses.SilkCar;
import br.com.ifpe.oficina.interfaces.IController;
import br.com.ifpe.oficina.persistence.CarDAOImpl;

public class GUICar {
	public void CarGUI() {

		String plate = "";
		Scanner scanner = new Scanner(System.in);
		CarController carController =  CarController.createController();

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

				case "2": // Update

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
