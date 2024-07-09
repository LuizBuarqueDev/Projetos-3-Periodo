package br.com.ifpe.oficina.persistence;

import java.util.List;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.MechanicManager;
import br.com.ifpe.oficina.interfaces.IGenericDAO;

public class CarDAOImpl implements IGenericDAO<Car> {

	private static final CarDAOImpl instance = new CarDAOImpl();

	public static CarDAOImpl getInstance() {
		return instance;
	}

	private CarDAOImpl() {
	}
	
	List<Car> carList = MechanicManager.getInstance().getCarList();

	@Override
	public void create(Car object) {
	}

	@Override
	public Car read(Car object) {
		return object;
	}

	@Override
	public void update(int index, Car object) {
		carList.set(index, object);
	}

	@Override
	public void delete(Car object) {
		carList.remove(object);
	}

	@Override
	public List<Car> viewAll() {
		return carList;
	}
}