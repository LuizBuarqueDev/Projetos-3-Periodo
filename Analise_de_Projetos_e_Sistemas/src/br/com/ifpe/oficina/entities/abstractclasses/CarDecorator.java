package br.com.ifpe.oficina.entities.abstractclasses;

import br.com.ifpe.oficina.entities.concreteclasses.Car;

public abstract class CarDecorator extends Car {
    protected Car decorated;

    public CarDecorator(Car decoretedCar) {
        this.decorated = decoretedCar;
    }

    @Override
    public double getPrice() {
        return decorated.getPrice();
    }

    public static class Carpets extends CarDecorator {
        public Carpets(Car decoretedCar) {
            super(decoretedCar);
        }

        @Override
        public double getPrice() {
            return super.getPrice() + 2000;
        }
    }

    public static class HeatedSeats extends CarDecorator {
        public HeatedSeats(Car decoretedCar) {
            super(decoretedCar);
        }

        @Override
        public double getPrice() {
            return super.getPrice() + 1500;
        }
    }
}
