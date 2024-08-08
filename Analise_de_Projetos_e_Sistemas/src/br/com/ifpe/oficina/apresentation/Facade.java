package br.com.ifpe.oficina.apresentation;

import br.com.ifpe.oficina.services.controllers.CarController;
import br.com.ifpe.oficina.services.controllers.ClientController;
import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.entities.concreteclasses.Car;

import java.util.List;

public class Facade {
    private final CarController carController = CarController.getInstance();
    private final ClientController clientController = ClientController.getInstance();

    public void createClient(Client client) {
        clientController.create(client);
    }

    public Client readClient(String cpf) {
        return clientController.read(cpf);
    }

    public void updateClient(Client client) {
        clientController.update(client);
    }

    public void deleteClient(String cpf) {
        clientController.delete(cpf);
    }

    public List<Client> viewAllClients() {
        return clientController.viewAll();
    }

    public void createCar(Car car, String... accessories) {
        carController.create(car, accessories);
    }

    public Car readCar(String plate) {
        return carController.read(plate);
    }

    public void updateCar(Car car, String... accessories) {
        carController.update(car, accessories);
    }

    public void deleteCar(String plate) {
        carController.delete(plate);
    }

    public List<Car> viewAllCars() {
        return carController.viewAll();
    }
}