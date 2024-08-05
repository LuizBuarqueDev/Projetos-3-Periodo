package br.com.ifpe.oficina.entities.abstractclasses;

public abstract class CarDecorator extends Car {
    protected Car decoreted;

    public CarDecorator(Car decoretedCar) {
        this.decoreted = decoretedCar;
        this.setEngine(decoretedCar.getEngine());
        this.setPlate(decoretedCar.getPlate());
        this.setTraction(decoretedCar.getTraction());
        this.setClient(decoretedCar.getClient());
    }

    @Override
    public double getprice() {
        return decoreted.getprice();
    }

    public static class AirConditioning extends CarDecorator {
        public AirConditioning(Car decoretedCar) {
            super(decoretedCar);
        }

        @Override
        public double getprice() {
            return super.getprice() + 2000;
        }
    }

    public static class HeatedSeats extends CarDecorator {
        public HeatedSeats(Car decoretedCar) {
            super(decoretedCar);
        }

        @Override
        public double getprice() {
            return super.getprice() + 1500;
        }
    }
}
