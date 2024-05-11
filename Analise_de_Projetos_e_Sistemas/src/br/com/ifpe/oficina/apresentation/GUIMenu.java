package br.com.ifpe.oficina.apresentation;

import java.util.Scanner;

public class GUIMenu {
	Scanner scanner = new Scanner(System.in);

	public static void runGUI() {
		Scanner scanner = new Scanner(System.in);

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
