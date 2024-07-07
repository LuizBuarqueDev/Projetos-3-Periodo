package br.com.ifpe.oficina.persistence;

import java.util.List;

import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.interfaces.IGenericDAO;

public class ClientDAOImpl implements IGenericDAO<Client>{
	
	private static final ClientDAOImpl instance = new ClientDAOImpl();

	public static ClientDAOImpl getInstance() {
		return instance;
	}

	@Override
	public void create(Client object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client read(Client object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Client object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Client object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Client> viewAll() {
		// TODO Auto-generated method stub
		return null;
	}
}