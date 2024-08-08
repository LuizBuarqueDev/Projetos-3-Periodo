package br.com.ifpe.oficina.entities.abstractclasses;

import br.com.ifpe.oficina.entities.concreteclasses.CarEngine;
import br.com.ifpe.oficina.entities.concreteclasses.Client;

public class Carpets implements IDecoratedCar {

    private final IDecoratedCar car;

    public Carpets(IDecoratedCar car) {
        this.car = car;
    }

    @Override
    public String getPlate() {
        return this.car.getPlate();
    }

    @Override
    public CarEngine getEngine() {
        return this.car.getEngine();
    }

    @Override
    public String getTraction() {
        return this.car.getTraction();
    }

    @Override
    public Client getClient() {
        return this.car.getClient();
    }

    @Override
    public double getPrice() {
        return this.car.getPrice() + 800;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plate='" + getPlate() + '\'' +
                ", traction='" + getTraction() + '\'' +
                ", engine=" + getEngine() +
                ", price=" + getPrice() +
                '}';
    }
}
