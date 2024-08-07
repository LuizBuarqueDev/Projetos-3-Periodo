package br.com.ifpe.oficina.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import br.com.ifpe.oficina.entities.concreteclasses.CarEngine;
import br.com.ifpe.oficina.entities.concreteclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.services.controllers.CarController;
import br.com.ifpe.oficina.services.controllers.ClientController;

public class LoadEntity {

    private static final LoadEntity instance = new LoadEntity();

    private CarController carController = CarController.getInstance();
    private ClientController clientController = ClientController.getInstance();

    private LoadEntity() {
    }

    public static LoadEntity getInstance() {
        return instance;
    }

    Random random = new Random();

    public void createRandomData() {
        generateClients(50);
        generateCars(50);
    }

    private void generateClients(int quantity) {
        Set<String> usedCpfs = new HashSet<>();

        for (int i = 0; i < quantity; i++) {
            String cpf;
            do {
                cpf = generateValidCPF();
            } while (!usedCpfs.add(cpf));
            Client client = Client.ClientBuilder.aClient()
                    .age(20 + i)
                    .cpf(cpf)
                    .email("cliente" + i + "@gmail.com")
                    .name("cliente" + i)
                    .build();

            clientController.viewAll().add(client);
        }
    }

    private void generateCars(int quantity) {
        for (int i = 0; i < quantity; i++) {
            int key = random.nextInt(2);
            Client client = clientController.viewAll().get(i);

            switch (key) {
                case 0: {
                    Car car = Car.CarBuilder.aCar()
                            .engine(new CarEngine(670, 5000, "Eletric"))
                            .client(client)
                            .plate("ABC-" + i)
                            .traction("4x2")
                            .build();

                    carController.viewAll().add(car);
                    client.setCar(car);
                    break;
                }
                case 1: {
                    Car car = Car.CarBuilder.aCar()
                            .engine(new CarEngine(500, 3000, "Combustion"))
                            .build();
                    car.setClient(client);
                    car.setPlate("DEF-" + i);
                    car.setTraction("4x4");

                    carController.viewAll().add(car);
                    client.setCar(car);
                    break;
                }
                default:
                    System.out.println("Unexpected value: " + key);
            }
        }
    }

    private String generateValidCPF() {
        Random random = new Random();
        int[] cpfArray = new int[11];

        for (int i = 0; i < 9; i++) {
            cpfArray[i] = random.nextInt(10);
        }

        cpfArray[9] = calculateCpfDigit(cpfArray, 9);
        cpfArray[10] = calculateCpfDigit(cpfArray, 10);

        StringBuilder cpf = new StringBuilder();
        for (int digit : cpfArray) {
            cpf.append(digit);
        }
        return cpf.toString();
    }

    private int calculateCpfDigit(int[] cpf, int length) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += cpf[i] * ((length + 1) - i);
        }
        int result = sum % 11;
        return (result < 2) ? 0 : 11 - result;
    }
}
