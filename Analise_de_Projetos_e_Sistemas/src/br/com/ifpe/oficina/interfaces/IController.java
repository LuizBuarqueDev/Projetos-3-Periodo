package br.com.ifpe.oficina.interfaces;

import java.util.List;

public interface IController<T>{
	
	T read (String plate);
	void delete(String plate);
	List<T> viewAll();
}
