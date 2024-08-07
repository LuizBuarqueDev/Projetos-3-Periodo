package br.com.ifpe.oficina.apresentation;

import java.util.Scanner;

import br.com.ifpe.oficina.entities.concreteclasses.Client;

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
                System.out.println("\n[1]-create\n[2]-update\n[3]-read\n[4]-delete\n[5]-view\n[6]-back");
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
                        System.out.println("O valor '" + choice + "' é invalido");
                        break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void create() {
        System.out.println("Idade: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Cpf: ");
        String cpf = scanner.nextLine();

        System.out.println("E-mail: ");
        String email = scanner.nextLine();

        System.out.println("Nome: ");
        String name = scanner.nextLine();

        Client client = Client.ClientBuilder.aClient()
                .name(name)
                .age(age)
                .email(email)
                .cpf(cpf)
                .build();

        facade.createClient(client);
        System.out.println("Cliente criado com sucesso");
    }

//    public Client createOnlyClient() {
//        try {
//            System.out.println("Criando cliente");
//            System.out.println("Idade: ");
//            int age = Integer.parseInt(scanner.nextLine());
//
//            System.out.println("Cpf: ");
//            String cpf = scanner.nextLine();
//
//            System.out.println("E-mail: ");
//            String email = scanner.nextLine();
//
//            System.out.println("Nome: ");
//            String name = scanner.nextLine();
//
//            return  null;
//        } catch (NumberFormatException e) {
//            throw new RuntimeException("A idade não é um inteiro");
//        }
//    }

    private void read() {
        System.out.println("Cpf: ");
        cpf = scanner.nextLine();
        System.out.println(facade.readClient(cpf));
    }

    private void update() {
        System.out.println("Digite o numero do cpf do cliente que deseja editar: ");
        String cpf = scanner.nextLine();

        System.out.println("Idade: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("E-mail: ");
        String email = scanner.nextLine();

        System.out.println("Nome: ");
        String name = scanner.nextLine();

        Client client = Client.ClientBuilder.aClient()
                .cpf(cpf)
                .age(age)
                .email(email)
                .name(name)
                .build();

        facade.updateClient(client);
    }

    private void delete() {
        System.out.println("Cpf: ");
        cpf = scanner.nextLine();
        facade.deleteClient(cpf);
        System.out.println("Cliente deletado");
    }
}