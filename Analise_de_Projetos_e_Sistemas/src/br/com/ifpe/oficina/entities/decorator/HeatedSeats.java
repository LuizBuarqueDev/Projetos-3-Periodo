package br.com.ifpe.oficina.entities.decorator;

import br.com.ifpe.oficina.entities.concreteclasses.Car;

public class HeatedSeats implements IBasicCar {

    private final IBasicCar car;

    public HeatedSeats(IBasicCar car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return car.toString().replaceFirst(", Total price with accessories: \\d+\\.\\d+", "") +
                ", Total price with accessories: " + getPrice();
    }

    @Override
    public Car getInnerCar() {
        return this.car.getInnerCar();
    }

    @Override
    public double getPrice() {
        double accessoryPrice = 2000;
        return this.car.getPrice() + accessoryPrice;
    }
}