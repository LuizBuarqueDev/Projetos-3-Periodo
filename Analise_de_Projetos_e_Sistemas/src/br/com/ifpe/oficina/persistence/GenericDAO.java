package br.com.ifpe.oficina.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GenericDAO<T> implements IGenericDAO<T> {
	
	private final List<T> list;

	public GenericDAO() {
		this.list = new ArrayList<T>();
	}

	@Override
	public void insert(T object) {
		list.add(object);
	}

	@Override
	public T read(Predicate<T> filter) {
		return this.list.stream().filter(filter).findFirst().orElse(null);
	}

	@Override
	public void update(int index, T object) {
		list.set(index, object);
	}

	@Override
	public void delete(T object) {
		list.remove(object);
	}

	@Override
	public List<T> listAll() {
		return list;
	}
}
