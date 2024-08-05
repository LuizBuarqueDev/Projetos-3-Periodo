package br.com.ifpe.oficina.services.controllers;


import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.interfaces.IController;
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

    private Client createClient(String name, String cpf, int age, String email) {
        return Client.ClientBuilder()
                .name(name)
                .cpf(cpf)
                .age(age)
                .email(email)
                .build();
    }

    @Override
    public void create(String... attributes) {
        String name = attributes[0];
        String strAge = attributes[1];
        String cpf = attributes[2];
        String email = attributes[3];

        try {
            int age = Integer.parseInt(strAge);
            genericInsert(createClient(name, cpf, age, email));

        } catch (NumberFormatException e) {
            throw new RuntimeException("Não foi possivel criar porque a idade inserida é invalida");
        }
    }

    @Override
    public Client read(String cpf) {
        return genericRead(searchClient(cpf));
    }

    @Override
    public void update(String... attributes) {
        String name = attributes[0];
        String strAge = attributes[1];
        String cpf = attributes[2];
        String email = attributes[3];
        String oldCpf = attributes[4];
        int age;

        try {
            age = Integer.parseInt(strAge);
        } catch (NumberFormatException e) {
            throw new RuntimeException("A idade fornecida não é um numero");
        }

        Client client = searchClient(oldCpf);
        if (client == null) {
            throw new RuntimeException("Cliente não encontrado");
        }

        try {
            Client clientCopy = (Client) client.clone();
            clientCopy.setName(name);
            clientCopy.setAge(age);
            clientCopy.setAge(age);
            clientCopy.setEmail(email);

            int index = viewAll().indexOf(client);
            genericUpdate(index, clientCopy);

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar o cliente");
        }
    }

    @Override
    public void delete(String cpf) {
        genericDelete(searchClient(cpf));
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
    protected void validateUpdate(Client object) {

    }
}
