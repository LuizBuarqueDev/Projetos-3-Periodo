package br.com.ifpe.oficina.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.ifpe.oficina.interfaces.IGenericDAO;

public class GenericDAO<T> implements IGenericDAO<T>{
	
	List<T> list = new ArrayList<T>();

	@Override
	public void create(T object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T read(T object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(int index, T object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> viewAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
