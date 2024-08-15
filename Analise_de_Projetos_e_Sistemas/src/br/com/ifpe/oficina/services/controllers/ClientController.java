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
    private final CarController carController = CarController.getInstance();

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
            carController.delete(client.getCar().getPlate(), true);
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
            throw new RuntimeException("Cliente não encontrado");
        }
        int index = viewAll().indexOf(oldClient);
        genericUpdate(index, newClient);
    }

    @Override
    public void delete(String cpf, boolean isDeletingCar) {
        Client client = searchClient(cpf);
        if (client == null) {
            throw new RuntimeException("Cliente não encontrado");
        }

        if (!isDeletingCar) {
            IBasicCar car = client.getCar();
            if (car != null) {
                carController.delete(car.getPlate(), true);
            }
        }
        genericDelete(client);
    }

    @Override
    public List<Client> viewAll() {
        return genericListAll();
    }

    @Override
    protected void validateInsert(Client client) {
        if (!cpfValidator.validateCpf(client.getCpf())) {
            throw new RuntimeException("Erro: Cpf invalidao");

        } else if (searchClient(client.getCpf()) != null) {
            throw new RuntimeException("Erro: O cpf digitado já existe");
        }
    }

    @Override
    protected void validateUpdate(Client client) {
        if (!cpfValidator.validateCpf(client.getCpf())) {
            throw new RuntimeException("Update Erro: Cpf invalido");
        }
    }
}