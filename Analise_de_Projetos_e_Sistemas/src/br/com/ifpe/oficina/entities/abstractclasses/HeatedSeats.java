package br.com.ifpe.oficina.entities.abstractclasses;

import br.com.ifpe.oficina.entities.concreteclasses.Car;

public class HeatedSeats extends Car implements IDecoratedCar {

    private IDecoratedCar car;

    public HeatedSeats(IDecoratedCar car) {
        this.car = car;
    }

    @Override
    public double getPrice() {
        return this.car.getPrice() + 2000;
    }
}
