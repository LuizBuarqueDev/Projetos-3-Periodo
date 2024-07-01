package br.com.ifpe.oficina.persistence;

import java.util.List;

import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.interfaces.IGenericDAO;

public class CarDAOImpl<T> implements IGenericDAO<T> {

    private static final CarDAOImpl<?> instance = new CarDAOImpl<>();

    public static <T> CarDAOImpl<T> getInstance() {
        return (CarDAOImpl<T>) instance;
    }

    private CarDAOImpl() {
        // Construtor privado para evitar instanciação externa
    }

    @Override
    public void create(T object) {
        // TODO Auto-generated method stub
    }

    @Override
    public T read(T object) {
    	if (object instanceof Car) {
    		Car car = (Car) object;
    		return (T)car.toString();
    	}
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

    @Override
    public List<T> viewAll() {
        // TODO Auto-generated method stub
        return null;
    }
}