package br.com.ifpe.oficina.business;

import java.util.List;

import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.interfaces.IController;
import br.com.ifpe.oficina.persistence.GenericDAO;

public class ClientController implements IController<Client> {
	
	private static final ClientController instance = new ClientController();	
	
	private GenericDAO<Client> clientDAO = GenericDAO.createInstance();
	
	public static ClientController getInstance() {
		return instance;
	}
	
	public void create() {
		
	}

	@Override
	public Client read(String unique_key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void update() {
		
	}

	@Override
	public void delete(String unique_key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Client> viewAll() {
		return clientDAO.viewAll();
	}
}
