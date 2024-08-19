package br.com.ifpe.oficina.services.controllers;

import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.entities.decorator.IBasicCar;
import br.com.ifpe.oficina.persistence.GenericDAO;
import br.com.ifpe.oficina.services.factories.DAOFactory;
import br.com.ifpe.oficina.services.validators.CpfValidator;

import java.util.List;
import java.util.function.Predicate;

public class ClientController extends GenericController<Client> implements IController<Client> {

    private static final ClientController instance = new ClientController(DAOFactory.createDAO(Client.class));

    private final CpfValidator cpfValidator = new CpfValidator();

    private ClientController(GenericDAO<Client> dao) {
        super(dao);
    }

    public static ClientController getInstance() {
        return instance;
    }

    private Client searchClient(String cpf) {
        Predicate<Client> filterByClient = client -> client.getCpf().equals(cpf);
        return dao.read(filterByClient);
    }

    public void create(Client client) {
        try {
            genericInsert(client);
        } catch (Exception e) {
            CarController.getInstance().delete(client.getCar().getInnerCar().getPlate(), false);
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Client read(String cpf) {
        return genericRead(searchClient(cpf));
    }

    @Override
    public void update(Client newClient) {
        Client oldClient = searchClient(newClient.getCpf());
        if (oldClient == null) {
            throw new RuntimeException("Update error: Client not found");
        }
        newClient.setCar(oldClient.getCar());
        int index = viewAll().indexOf(oldClient);
        genericUpdate(index, newClient);
    }

    @Override
    public void delete(String cpf, boolean isDeletingCar) {
        Client client = searchClient(cpf);
        genericDelete(client);
        if (isDeletingCar) {
            IBasicCar car = client.getCar();
            if (car != null) {
                CarController.getInstance().delete(car.getInnerCar().getPlate(), false);
            }
        }
    }

    @Override
    public List<Client> viewAll() {
        return genericListAll();
    }

    @Override
    protected void validateInsert(Client client) {
        if (!cpfValidator.validateCpf(client.getCpf())) {
            throw new RuntimeException("Validate insert error: Invalid CPF");

        } else if (searchClient(client.getCpf()) != null) {
            throw new RuntimeException("Validate insert error: The cpf entered already exists");
        }
    }

    @Override
    protected void validateUpdate(Client client) {
        if (!cpfValidator.validateCpf(client.getCpf())) {
            throw new RuntimeException("Update error: Invalid CPF");
        }
    }
}
