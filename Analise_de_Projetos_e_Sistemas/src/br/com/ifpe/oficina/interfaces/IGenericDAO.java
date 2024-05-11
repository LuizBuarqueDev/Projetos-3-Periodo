package br.com.ifpe.oficina.interfaces;

import java.util.List;

public interface IGenericDAO<T> {
	void create(T object);
	T read ();
	void update (T object);
	void delete (T object);
	List<T> viewAll();
}
