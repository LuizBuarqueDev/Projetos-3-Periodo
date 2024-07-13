package br.com.ifpe.oficina.interfaces;

import java.util.List;

public interface IController<T>{
	
	T read (String unique_key);
	void delete(String unique_key);
	List<T> viewAll();
}
