package br.com.ifpe.oficina.persistence;

import java.util.List;

import br.com.ifpe.oficina.business.Controller;
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

	MechanicManager mechanicManager = MechanicManager.getInstance();

	@Override
	public void create(Car object) {
		// TODO Auto-generated method stub
	}

	@Override
	public Car read(Car object) {
		Controller controller = Controller.createController();
		
		if (object instanceof Car) {
			return controller.searchCar(object.getPlate());
		} else {
			return null; // TODO: Laçar uma exeção
		}
	}

	@Override
	public void update(Car object) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Car object) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Car> viewAll() {
		return mechanicManager.getCarList();
	}
}