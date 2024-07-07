package br.com.ifpe.oficina.apresentation;

import java.util.Scanner;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.MechanicManager;
import br.com.ifpe.oficina.entities.concreteclasses.SilkCar;
import br.com.ifpe.oficina.persistence.CarDAOImpl;

public class GUICar {
	public void CarGUI() {

		String plate = "";
		Car car = new SilkCar();
		Scanner scanner = new Scanner(System.in);
		CarDAOImpl carDAOImpl = CarDAOImpl.getInstance();
		
		while (true) {
			System.out.println("\n[1]-create\n[2]-update\n[3]-read\n[4]-delete\n[5]-view all");
			String choice = scanner.nextLine();

			switch (choice) {

			case "1": // Create
//				System.out.print("Digite a placa: ");
//				plate = scanner.nextLine();
//				if (workshopManager.searchCar(plate) == null) {
//					// create
//				} else {
//					System.out.println("A placa digitada já existe");
//				}
				break;

			case "2": // Update

				break;

			case "3": // Read
				// TODO: colocar Try/Cath
				System.out.print("Digite a placa: ");
				plate = scanner.nextLine();
//					System.out.println("A placa digitada não existe");
				car.setPlate(plate);
				System.out.println(carDAOImpl.read(car));
				break;

			case "4": // Delete
//				System.out.print("Digite a placa: ");
//				plate = scanner.nextLine();
//				car = workshopManager.searchCar(plate);
//				if (car == null) {
//					System.out.println("A placa digitada não existe");
//				} else {
//
//				}
				break;

			case "5":

				break;

			default:
				System.out.println("O valor " + choice + "é invalido");
				break;
			}
		}
	}
}
