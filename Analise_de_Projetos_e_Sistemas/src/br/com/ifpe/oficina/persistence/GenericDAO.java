package br.com.ifpe.oficina.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.ifpe.oficina.interfaces.IGenericDAO;

public class GenericDAO<T> implements IGenericDAO<T> {
	
	List<T> list = new ArrayList<T>();
	
	private GenericDAO() {
	}

	public static <T> GenericDAO<T> createInstance(){
		return new GenericDAO<T>();
	}
	
	@Override
	public void create(T object) {
		list.add(object);
	}

	@Override
	public T read(T object) {
		return object;
	}

	@Override
	public void update(int index, T object) {
	}

	@Override
	public void delete(T object) {
		list.remove(object);
	}

	@Override
	public List<T> viewAll() {
		return list;
	}
}
