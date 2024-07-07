package br.com.ifpe.oficina.apresentation;

import java.util.Scanner;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.MechanicManager;
import br.com.ifpe.oficina.entities.concreteclasses.SilkCar;
import br.com.ifpe.oficina.interfaces.IController;
import br.com.ifpe.oficina.persistence.CarDAOImpl;

public class GUICar {
	public void CarGUI() {

		String plate = "";
		Car car = new SilkCar();
		Scanner scanner = new Scanner(System.in);
		CarDAOImpl carDAOImpl = CarDAOImpl.getInstance();

		while (true) {

			try {

				System.out.println("\n[1]-create\n[2]-update\n[3]-read\n[4]-delete\n[5]-view all");
				String choice = scanner.nextLine();

				switch (choice) {

				case "1": // Create
					
					break;

				case "2": // Update

					break;

				case "3": // Read
					System.out.print("Digite a placa: ");
					plate = scanner.nextLine();
					car.setPlate(plate);
					System.out.println(carDAOImpl.read(car));
					break;

				case "4": // Delete
					break;

				case "5":

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
