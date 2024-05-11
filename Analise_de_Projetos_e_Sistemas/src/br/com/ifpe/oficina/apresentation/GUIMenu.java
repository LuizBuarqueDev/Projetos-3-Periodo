package br.com.ifpe.oficina.apresentation;

import java.util.Scanner;

import br.com.ifpe.oficina.entities.concreteclasses.WorkshopManager;

public class GUIMenu {
	Scanner scanner = new Scanner(System.in);

	public static void runGUI() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println();

		while (true) {
			System.out.println("[1]-client\n[2]-car");
			String choise = scanner.nextLine();
			
			switch (choise) {
			case "1":
				GUIClient.clientGUI();
				break;
			case "2":
				GUICar.CarGUI();
				break;

			default:
				System.err.println("Opção " + choise + " é invalida");
				break;
			}
		System.out.println("--------------------------------------------------");
		}
	}
}
