package br.com.ifpe.oficina.services.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.entities.decorator.IBasicCar;
import br.com.ifpe.oficina.persistence.GenericDAO;
import br.com.ifpe.oficina.services.factories.DAOFactory;

public class CarController extends GenericController<IBasicCar> implements IController<IBasicCar> {

    private static final CarController instance = new CarController(DAOFactory.createDAO(IBasicCar.class));

    private CarController(GenericDAO<IBasicCar> dao) {
        super(dao);
    }

    public static CarController getInstance() {
        return instance;
    }

    private IBasicCar searchCar(String plate) {
        Predicate<IBasicCar> filterByCar = car -> car.getPlate().equals(plate);
        return dao.read(filterByCar);
    }

    @Override
    public void create(IBasicCar car) {
        genericInsert(car);
    }

    @Override
    public IBasicCar read(String plate) {
        return genericRead(searchCar(plate));
    }

    @Override
    public void update(IBasicCar newCar) {
        IBasicCar oldCar = searchCar(newCar.getPlate());
        if (oldCar == null) {
            throw new RuntimeException("Carro não encontrado");
        }
        newCar.setClient(oldCar.getClient());
        int index = viewAll().indexOf(oldCar);
        genericUpdate(index, newCar);
    }

    @Override
    public void delete(String plate, boolean isDeletingClient) {
        IBasicCar car = searchCar(plate);
        if (car == null) {
            throw new RuntimeException("Carro não encontrado");
        }

        if (!isDeletingClient) {
            ClientController clientController = ClientController.getInstance();
            Client client = car.getClient();
            if (client != null) {
                clientController.delete(client.getCpf(), true);
            }
        }
        genericDelete(car);
    }

    @Override
    public List<IBasicCar> viewAll() {
        return genericListAll();
    }

    @Override
    protected void validateInsert(IBasicCar car) {
        if (searchCar(car.getPlate()) != null) {
            throw new RuntimeException("Não foi possivel inserir placa já existe");
        }
    }

    @Override
    protected void validateUpdate(IBasicCar car) {
        if (searchCar(car.getPlate()) == null) {
            throw new RuntimeException("Placa não encontrada");
        }
    }
}