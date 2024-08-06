package br.com.ifpe.oficina.apresentation;

import java.util.Scanner;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.entities.concreteclasses.CombustionCar;
import br.com.ifpe.oficina.entities.concreteclasses.EletricCar;
import br.com.ifpe.oficina.services.controllers.CarController;

public class GUICar {

    private static final GUICar instance = new GUICar();

    String plate = "";
    Scanner scanner = new Scanner(System.in);
    Facade facade = new Facade();

    private GUICar() {
    }

    public static GUICar getInstance() {
        return instance;
    }

    public void CarGUI() {
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
                        facade.viewAllCars().forEach(System.out::println);
                        break;

                    case "6":
                        loop = false;
                        break;

                    default:
                        System.out.println("O valor " + choice + " é inválido");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void create() {
        System.out.print("Digite a placa: ");
        String plate = scanner.nextLine();

        System.out.print("Digite a tração: ");
        String traction = scanner.nextLine();

        System.out.print("Digite o tipo de carro:[1] - combustao / [2] - eletrico): ");
        String type = scanner.nextLine();

        System.out.println("Digite a quantidade de cada elemento");
        System.out.println("Ar condicionado: ");
        String air = scanner.nextLine();
        System.out.println("Acentos aquecidos: ");
        String seat = scanner.nextLine();

        facade.createCar(type, plate, traction, air, seat);
        System.out.println("Carro criado com sucesso");
    }

    public Car createOnlyCar() {
        System.out.println("Criando carro");
        System.out.print("Digite a placa: ");
        String plate = scanner.nextLine();

        System.out.print("Digite a tração: ");
        String traction = scanner.nextLine();

        System.out.print("Digite o tipo de carro:[1] - combustao / [2] - eletrico): ");
        String type = scanner.nextLine();

        try {
            if (type.equals("1")) {
                System.out.println("Caso 1");
                return CombustionCar.CombustionCarBuilder.aCombustionCar()
                        .plate(plate)
                        .traction(traction)
                        .client(Client.ClientBuilder().build())
                        .build();

            } else if (type.equals("2")) {
                System.out.println("Caso 2");
                return EletricCar.EletricCarBuilder.anEletricCar()
                        .plate(plate)
                        .traction(traction)
                        .client(Client.ClientBuilder().build())
                        .build();

            } else {
                System.out.println("Caso Erro else");
                throw new IllegalArgumentException("Parametros invalidos, tente novamente");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Parametros invalidos, tente novamente");
        }
    }

    private void update() {
        System.out.print("Digite a placa do carro que deseja atualizar: ");
        String oldPlate = scanner.nextLine();

        System.out.print("Digite a placa do carro que deseja atualizar: ");
        String newPlate = scanner.nextLine();

        System.out.print("Digite a nova tração: ");
        String traction = scanner.nextLine();

        facade.updateCar(oldPlate, newPlate, traction);
        System.out.println("Carro atualizado com sucesso");
    }

    private void read() {
        System.out.print("Digite a placa: ");
        plate = scanner.nextLine();
        System.out.println(facade.readCar(plate));
    }

    private void delete() {
        System.out.print("Digite a placa: ");
        plate = scanner.nextLine();
        facade.deleteCar(plate);
        System.out.println("Carro removido");
    }
}