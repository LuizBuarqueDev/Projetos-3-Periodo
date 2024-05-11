package br.com.ifpe.oficina.persistence;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.interfaces.IGenericDAO;

public class CarDAOImpl<T> implements IGenericDAO<T>{
	
	private Car car;

	@Override
	public void create(T object) {
		// TODO Auto-generated method stub
		this.car = (Car) object;
	}

	@Override
	public T read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(T object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T object) {
		// TODO Auto-generated method stub
		
	}

}
