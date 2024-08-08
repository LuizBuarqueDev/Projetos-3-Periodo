package br.com.ifpe.oficina.entities.abstractclasses;

import br.com.ifpe.oficina.entities.concreteclasses.Car;

public class Carpets extends Car implements IDecoratedCar {

    private final IDecoratedCar car;

    public Carpets(IDecoratedCar car) {
        this.car = car;
    }

    @Override
    public double getPrice() {
        return this.car.getPrice() + 800;
    }
}
