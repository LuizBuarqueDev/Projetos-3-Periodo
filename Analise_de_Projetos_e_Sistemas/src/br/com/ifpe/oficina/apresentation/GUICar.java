package br.com.ifpe.oficina.apresentation;

import java.util.Scanner;

import br.com.ifpe.oficina.entities.concreteclasses.WorkshopManager;

public class GUICar {
	public static void CarGUI() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\n[1]-create\n[2]-update\n[3]-read\n[4]-delete\n[5]-view all");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				System.out.print("Digite a placa: ");
				String plate = scanner.nextLine();
				if(WorkshopManager.getInstance().searchCar(plate) == null) {
					//create
				} else {
					System.out.println("A placa digitada já existe");
				}
				
			case "2":

				break;
				
			case "3":

				break;
				
			case "4":

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
