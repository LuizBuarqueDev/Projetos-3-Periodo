package br.com.ifpe.oficina.apresentation;

import java.util.Scanner;

import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.entities.decorator.IBasicCar;
import br.com.ifpe.oficina.persistence.Logger;

public class GUIClient {

    private static final GUIClient instance = new GUIClient();

    Scanner scanner = new Scanner(System.in);
    String cpf = "";
    Facade facade = new Facade();

    private GUIClient() {
    }

    public static GUIClient getInstace() {
        return instance;
    }

    public void clientGUI() {
        boolean loop = true;
        while (loop) {
            try {
                System.out.println("\n[1]-create\n[2]-update\n[3]-read\n[4]-delete\n[5]-view all\n[6]-back");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1": // Create
                        create();

                        break;
                    case "2": // Update
                        update();

                        break;
                    case "3": // Read
                        read();

                        break;
                    case "4": // Delete
                        delete();
                        break;
                    case "5": // All
                        facade.viewAllClients().forEach(System.out::println);
                        break;

                    case "6":
                        loop = false;
                        break;

                    default:
                        System.out.println("The Value '" + choice + "' is valid");
                        break;
                }

            } catch (NumberFormatException e) {
                String text = "Error creating, invalid value provided :" + e.getMessage();
                System.out.println(text);
                Logger.error(text);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                Logger.error(e.getMessage());
            }
        }
    }

    public void create() {
        System.out.println("Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Cpf: ");
        String cpf = scanner.nextLine();

        System.out.println("E-mail: ");
        String email = scanner.nextLine();

        System.out.println("Name: ");
        String name = scanner.nextLine();

        Client client = Client.ClientBuilder.aClient()
                .name(name)
                .age(age)
                .email(email)
                .cpf(cpf)
                .build();

        IBasicCar car = GUICar.getInstance().createOnlyCar(client);
        client.setCar(car);

        facade.createClient(client);
        facade.createCar(car);
        System.out.println("Client created successfully");
    }

    public Client createOnlyClient(IBasicCar car) {
        System.out.println("Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Cpf: ");
        String cpf = scanner.nextLine();

        System.out.println("E-mail: ");
        String email = scanner.nextLine();

        System.out.println("Name: ");
        String name = scanner.nextLine();

        Client client = Client.ClientBuilder.aClient()
                .name(name)
                .age(age)
                .email(email)
                .cpf(cpf)
                .car(car)
                .build();

        System.out.println("Client created successfully");
        return client;
    }

    private void read() {
        System.out.println("Cpf: ");
        cpf = scanner.nextLine();
        System.out.println(facade.readClient(cpf));
    }

    private void update() {
        System.out.println("Enter the CPF number of the customer you want to edit: ");
        String cpf = scanner.nextLine();

        System.out.println("Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("E-mail: ");
        String email = scanner.nextLine();

        System.out.println("Name: ");
        String name = scanner.nextLine();

        Client client = Client.ClientBuilder.aClient()
                .cpf(cpf)
                .age(age)
                .email(email)
                .name(name)
                .build();

        facade.updateClient(client);
        System.out.println("Updated client");
    }

    private void delete() {
        System.out.println("Cpf: ");
        cpf = scanner.nextLine();
        facade.deleteClient(cpf);
        System.out.println("Client deleted");
    }
}