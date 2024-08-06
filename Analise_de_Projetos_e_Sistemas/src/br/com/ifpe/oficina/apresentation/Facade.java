package br.com.ifpe.oficina.apresentation;

import br.com.ifpe.oficina.services.controllers.CarController;
import br.com.ifpe.oficina.services.controllers.ClientController;
import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.entities.abstractclasses.Car;

import java.util.List;

public class Facade {
    private static final Facade instance = new Facade();

    private final CarController carController = CarController.getInstance();
    private final ClientController clientController = ClientController.getInstance();

    public static Facade getInstance() {
        return instance;
    }

    private Facade() {
    }
    // Métodos para ClientController

    public void createClient(String name, String age, String cpf, String email) {
        clientController.create(name, age, cpf, email);
    }

    public Client readClient(String cpf) {
        return clientController.read(cpf);
    }

    public void updateClient(String name, String age, String cpf, String email, String oldCpf) {
        clientController.update(name, age, cpf, email, oldCpf);
    }

    public void deleteClient(String cpf) {
        clientController.delete(cpf);
    }

    public List<Client> viewAllClients() {
        return clientController.viewAll();
    }

    // Métodos para CarController
    public void createCar(String type, String plate, String traction, String air, String seats) {
        carController.create(type, plate, traction, air, seats);
    }

    public Car readCar(String plate) {
        return carController.read(plate);
    }

    public void updateCar(String oldPlate, String newPlate, String traction) {
        carController.update(oldPlate, newPlate, traction);
    }

    public void deleteCar(String plate) {
        carController.delete(plate);
    }

    public List<Car> viewAllCars() {
        return carController.viewAll();
    }
}