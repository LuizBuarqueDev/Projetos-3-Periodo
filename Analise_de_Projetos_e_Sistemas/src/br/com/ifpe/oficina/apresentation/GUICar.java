package br.com.ifpe.oficina.apresentation;

import java.util.Scanner;

import br.com.ifpe.oficina.entities.concreteclasses.CarEngine;
import br.com.ifpe.oficina.entities.concreteclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.entities.decorator.IBasicCar;
import br.com.ifpe.oficina.persistence.Logger;

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
            } catch (NumberFormatException e) {
                String text = "Erro o criar, valor fonecido invalido :" + e.getMessage();
                System.out.println(text);
                Logger.error(text);

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                Logger.error(e.getMessage());
            }
        }
    }

    private void create() {
        System.out.print("Digite a placa: ");
        String plate = scanner.nextLine();
        System.out.print("Digite a tração: ");
        String traction = scanner.nextLine();

        System.out.println("Tipo do motor: ");
        String engineType = scanner.nextLine();
        System.out.println("Potencia: ");
        int cvEngine = Integer.parseInt(scanner.nextLine());
        System.out.println("Rotaçao maxima: ");
        int rpmEngine = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite a quantidade de cada elemento");
        System.out.println("Carpetes: ");
        int carpets = Integer.parseInt(scanner.nextLine());
        System.out.println("Acentos aquecidos: ");
        int seat = Integer.parseInt(scanner.nextLine());

        IBasicCar car = Car.CarBuilder.aCar()
                .plate(plate)
                .traction(traction)
                .engine(new CarEngine(cvEngine, rpmEngine, engineType))
                .build();

        Client client = GUIClient.getInstace().createOnlyClient(car);
        car.getInnerCar().setClient(client);

        car = facade.applyCarAccessories(car, carpets, seat);
        facade.createCar(car);
        facade.createClient(client);
        System.out.println("Carro criado com sucesso");
    }

    public IBasicCar createOnlyCar(Client client) {
        System.out.print("Digite a placa: ");
        String plate = scanner.nextLine();
        System.out.print("Digite a tração: ");
        String traction = scanner.nextLine();

        System.out.println("Tipo do motor: ");
        String engineType = scanner.nextLine();
        System.out.println("Potencia: ");
        int cvEngine = Integer.parseInt(scanner.nextLine());
        System.out.println("Rotaçao maxima: ");
        int rpmEngine = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite a quantidade de cada elemento");
        System.out.println("Carpetes: ");
        int carpets = Integer.parseInt(scanner.nextLine());
        System.out.println("Acentos aquecidos: ");
        int seat = Integer.parseInt(scanner.nextLine());

        IBasicCar car = Car.CarBuilder.aCar()
                .plate(plate)
                .traction(traction)
                .engine(new CarEngine(cvEngine, rpmEngine, engineType))
                .client(client)
                .build();

        car = facade.applyCarAccessories(car, carpets, seat);

        System.out.println("Carro criado com sucesso");
        return car;
    }

    private void update() {
        System.out.print("Digite a placa que deseja modificar: ");
        String plate = scanner.nextLine();
        System.out.print("Digite a tração: ");
        String traction = scanner.nextLine();

        System.out.println("Tipo do motor: ");
        String engineType = scanner.nextLine();
        System.out.println("Potencia: ");
        int cvEngine = Integer.parseInt(scanner.nextLine());
        System.out.println("Rotaçao maxima: ");
        int rpmEngine = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite a quantidade de cada elemento");
        System.out.println("Carpetes: ");
        int carpets = Integer.parseInt(scanner.nextLine());
        System.out.println("Acentos aquecidos: ");
        int seat = Integer.parseInt(scanner.nextLine());

        IBasicCar car = Car.CarBuilder.aCar()
                .plate(plate)
                .traction(traction)
                .engine(new CarEngine(cvEngine, rpmEngine, engineType))
                .build();

        car = facade.applyCarAccessories(car, carpets, seat);

        facade.updateCar(car);
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