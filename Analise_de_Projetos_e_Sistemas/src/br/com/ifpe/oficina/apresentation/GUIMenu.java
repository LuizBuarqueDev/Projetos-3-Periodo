package br.com.ifpe.oficina.apresentation;

import java.util.Scanner;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.WorkshopManager;

public class GUIMenu {
	Scanner scanner = new Scanner(System.in);

	public static void runGUI() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println();

		while (true) {
			System.out.println("[1]-Client\n[2]-Car\n[3]-View All");
			String choise = scanner.nextLine();
			
			switch (choise) {
			case "1":
				GUIClient.clientGUI();
				break;
			case "2":
				GUICar.CarGUI();
				break;
			case "3":
				System.out.println(WorkshopManager.getInstance().getWorkshopName());
				System.out.println(WorkshopManager.getInstance().getAddress());
				System.out.println(WorkshopManager.getInstance().getCnpj());
				
				for(Car car : WorkshopManager.getInstance().getCarList()) {
					car.toString();					
				}
				break;

			default:
				System.err.println("Opção " + choise + " é invalida");
				break;
			}
		System.out.println("--------------------------------------------------");
		}
	}
}
