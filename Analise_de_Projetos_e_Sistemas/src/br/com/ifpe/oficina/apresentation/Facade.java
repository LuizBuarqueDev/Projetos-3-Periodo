package br.com.ifpe.oficina.apresentation;

import br.com.ifpe.oficina.entities.decorator.IBasicCar;
import br.com.ifpe.oficina.services.controllers.CarController;
import br.com.ifpe.oficina.services.controllers.ClientController;
import br.com.ifpe.oficina.entities.concreteclasses.Client;

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
        clientController.delete(cpf, false);
    }

    public List<Client> viewAllClients() {
        return clientController.viewAll();
    }


    public IBasicCar applyCarAccessories(IBasicCar car, int carpets, int seats) {
        return carController.applyAccessories(car, carpets, seats);
    }

    public void createCar(IBasicCar car) {
        carController.create(car);
    }

    public IBasicCar readCar(String plate) {
        return carController.read(plate);
    }

    public void updateCar(IBasicCar car) {
        carController.update(car);
    }

    public void deleteCar(String plate) {
        carController.delete(plate, false);
    }

    public List<IBasicCar> viewAllCars() {
        return carController.viewAll();
    }
}