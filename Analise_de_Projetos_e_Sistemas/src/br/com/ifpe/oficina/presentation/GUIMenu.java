package br.com.ifpe.oficina.presentation;

import java.util.Scanner;

public class GUIMenu {
    public static void runGUI() {

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        boolean loop = true;

        while (loop) {
            System.out.println("[1]-Client\n[2]-Car\n[3]-Exit");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    GUIClient guiClient = GUIClient.getInstance();
                    guiClient.clientGUI();
                    break;

                case "2":
                    GUICar guiCar = GUICar.getInstance();
                    guiCar.CarGUI();
                    break;

                case "3":
                    loop = false;
                    break;

                default:
                    System.err.println("Option " + choice + " is invalid");
                    break;
            }
            System.out.println("--------------------------------------------------");
        }
    }
}
