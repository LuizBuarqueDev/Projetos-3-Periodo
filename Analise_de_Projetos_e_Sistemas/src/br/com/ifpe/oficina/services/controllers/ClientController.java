package br.com.ifpe.oficina.services.controllers;

import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.entities.decorator.IBasicCar;
import br.com.ifpe.oficina.persistence.GenericDAO;
import br.com.ifpe.oficina.services.factories.DAOFactory;
import br.com.ifpe.oficina.services.validators.CpfValidator;

import java.util.List;
import java.util.function.Predicate;

public class ClientController extends GenericController<Client> {

    private static final ClientController instance = new ClientController(DAOFactory.createDAO(Client.class));

    private final CpfValidator cpfValidator = new CpfValidator();

    private ClientController(GenericDAO<Client> dao) {
        super(dao);
    }

    public static ClientController getInstance() {
        return instance;
    }

    @Override
    protected Client search(String cpf) {
        Predicate<Client> filterByClient = client -> client.getCpf().equals(cpf);
        return dao.read(filterByClient);
    }

    @Override
    protected void validateInsert(Client client) {
        if (!cpfValidator.validateCpf(client.getCpf())) {
            throw new RuntimeException("Validate insert error: Invalid CPF");

        } else if (search(client.getCpf()) != null) {
            throw new RuntimeException("Validate insert error: The cpf entered already exists");
        }
    }

    @Override
    protected Client validateUpdate(Client newClient) {
        Client oldClient = search(newClient.getCpf());
        if (!cpfValidator.validateCpf(newClient.getCpf())) {
            throw new RuntimeException("Update error: Invalid CPF");
        }
        if (oldClient == null) {
            throw new RuntimeException("Update error: Client not found");
        }
        newClient.setCar(oldClient.getCar());
        return oldClient;
    }

    @Override
    protected void afterDelete(Client client, boolean deleteAssociation) {
        IBasicCar car = client.getCar();
        if (car != null && deleteAssociation) {
            CarController.getInstance().delete(car.getInnerCar().getPlate(), false);
        }
    }

    @Override
    protected void fixInsert(Client client) {
        CarController.getInstance().delete(client.getCar().getInnerCar().getPlate(), false);
    }
}
