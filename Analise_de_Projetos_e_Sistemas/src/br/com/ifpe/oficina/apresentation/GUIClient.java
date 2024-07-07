package br.com.ifpe.oficina.apresentation;

import java.util.Scanner;

public class GUIClient {

	public  void clientGUI() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\n[1]-create\n[2]-update\n[3]-read\n[4]-delete\n[5]-view all");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":	

				break;
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
