package br.com.ifpe.oficina.entities.decorator;

import br.com.ifpe.oficina.entities.concreteclasses.CarEngine;
import br.com.ifpe.oficina.entities.concreteclasses.Client;

public class HeatedSeats implements IDecoratedCar {

    private IDecoratedCar car;

    public HeatedSeats(IDecoratedCar car) {
        this.car = car;
    }

    @Override
    public String getPlate() {
        return "";
    }

    @Override
    public CarEngine getEngine() {
        return null;
    }

    @Override
    public String getTraction() {
        return "";
    }

    @Override
    public Client getClient() {
        return null;
    }

    @Override
    public double getPrice() {
        return this.car.getPrice() + 2000;
    }
}
