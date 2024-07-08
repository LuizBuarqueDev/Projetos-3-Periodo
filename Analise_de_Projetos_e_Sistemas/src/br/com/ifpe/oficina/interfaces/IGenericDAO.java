package br.com.ifpe.oficina.interfaces;

import java.util.List;

public interface IGenericDAO<T> {
	void create(T object);
	T read (T object);
	void update (int index ,T object);
	void delete (T object);
	List<T> viewAll();
}
