package br.com.ifpe.oficina.interfaces;

import java.util.List;

import br.com.ifpe.oficina.entities.abstractclasses.Car;

public interface IController{
	
	void create(String plate);
	Car read (String plate);
	void update(String plate);
	void delete(String plate);
	List<Car> viewAll();
}
