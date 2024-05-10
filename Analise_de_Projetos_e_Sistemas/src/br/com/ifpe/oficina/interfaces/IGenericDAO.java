package br.com.ifpe.oficina.interfaces;

public interface IGenericDAO<T> {
	void create(T object);
	T read ();
	void update (T object);
	void delete (T object);
}
