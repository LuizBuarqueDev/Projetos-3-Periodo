package br.com.ifpe.oficina.apresentation;

import java.util.Scanner;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.Employee;
import br.com.ifpe.oficina.entities.concreteclasses.WorkshopManager;

public class GUIMenu {
	public static void runGUI() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println();

		while (true) {
			System.out.println("[1]-Client\n[2]-Car\n[3]-View All");
			String choice = scanner.nextLine();
			
			switch (choice) {
			case "1":
				GUIClient.clientGUI();
				break;
			case "2":
				GUICar.CarGUI();
				break;
			case "3":
				System.out.println(WorkshopManager.getInstance().viewAll());
				break;
				

			default:
				System.err.println("Opção " + choice + " é invalida");
				break;
			}
		System.out.println("--------------------------------------------------");
		}
	}
}
