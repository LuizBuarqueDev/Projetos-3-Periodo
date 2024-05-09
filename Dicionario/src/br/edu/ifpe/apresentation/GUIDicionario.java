package br.edu.ifpe.apresentation;

import java.util.Scanner;

public class GUIDicionario {
	public static void menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[1]-inserir\n[2]-busca\n[3]-remoção");
		String key = scanner.next();
		switch (key) {
		case "1":
			System.out.print("Inserção: ");
			break;
			
		case "2":
			System.out.print("Busca: ");
			break;
			
		case "3":
			System.out.print("Remoção: ");
			break;

		default:
			System.out.println(key + "é invalido");
			break;
		}
		
		
	}
}
