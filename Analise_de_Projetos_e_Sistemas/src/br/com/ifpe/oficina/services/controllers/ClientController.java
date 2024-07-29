package br.com.ifpe.oficina.services.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.interfaces.IController;
import br.com.ifpe.oficina.persistence.GenericDAO;
import br.com.ifpe.oficina.services.factories.DAOFactory;
import br.com.ifpe.oficina.services.validators.CpfValidator;

public class ClientController implements IController<Client> {

    private static final ClientController instance = new ClientController();

    private GenericDAO<Client> clientDAO = DAOFactory.createDAO(Client.class);
    private CpfValidator cpfValidator = new CpfValidator();

    public static ClientController getInstance() {
        return instance;
    }

    private ClientController() {}

    private Client searchClient(String cpf) {
        Predicate<Client> filterByClient = client -> client.getCpf().equals(cpf);
        return clientDAO.read(filterByClient);
    }

    public void create(String name, String age, String cpf, String email) {
        if (searchClient(cpf) != null) {
            throw new IllegalArgumentException("o cpf '" + cpf + "' já existe");

        } else if (!cpfValidator.validateCpf(cpf)) {
            throw new IllegalArgumentException("o cpf '" + cpf + "' não " +
                    "é valido");

        } else {
            System.out.println("Cpf valido");
        }
    }

    @Override
    public Client read(String unique_key) {
        Client client = searchClient(unique_key);
        if (client == null) {
            throw new NoSuchElementException("O cpf '" + unique_key + "'	não foi encontrado");
        }
        return client;
    }

    public void update() {

    }

    @Override
    public void delete(String unique_key) {
        Client client = searchClient(unique_key);
        if (client == null) {
            throw new NoSuchElementException("O cpf '" + unique_key + "'	não foi encontrado");
        }
    }

    @Override
    public List<Client> viewAll() {
        return clientDAO.viewAll();
    }
}
