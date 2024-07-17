package br.com.ifpe.oficina.services.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.interfaces.IController;
import br.com.ifpe.oficina.persistence.GenericDAO;

public class ClientController implements IController<Client> {
	
	private static final ClientController instance = new ClientController();	
	
	private GenericDAO<Client> clientDAO = new GenericDAO<Client>();
	
	public static ClientController getInstance() {
		return instance;
	}
	
	private ClientController() {}
	
	private Client searchClient(String cpf) {
	    return viewAll().stream()
	            .filter(client -> client.getCpf().equals(cpf))
	            .findFirst()
	            .orElse(null);
	}
	
	public void create() {	
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
