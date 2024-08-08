package br.com.ifpe.oficina.entities.concreteclasses;

import br.com.ifpe.oficina.entities.decorator.IDecoratedCar;

public class Car implements IDecoratedCar {

    private String plate;
    private CarEngine engine;
    private String traction;
    private Client client;

    private Car(String plate, CarEngine engine, String traction, Client client) {
        this.plate = plate;
        this.engine = engine;
        this.traction = traction;
        this.client = client;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "plate='" + plate + '\'' +
                ", traction='" + traction + '\'' +
                ", engine=" + engine +
                '}';
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public CarEngine getEngine() {
        return engine;
    }

    public void setEngine(CarEngine engine) {
        this.engine = engine;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getTraction() {
        return traction;
    }

    public void setTraction(String traction) {
        this.traction = traction;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    public static final class CarBuilder {
        private Client client;
        private String plate;
        private CarEngine engine;
        private String traction;

        private CarBuilder() {
        }

        public static CarBuilder aCar() {
            return new CarBuilder();
        }

        public CarBuilder client(Client client) {
            this.client = client;
            return this;
        }

        public CarBuilder plate(String plate) {
            this.plate = plate;
            return this;
        }

        public CarBuilder engine(CarEngine engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder traction(String traction) {
            this.traction = traction;
            return this;
        }

        public Car build() {
            return new Car(plate, engine, traction, client);
        }
    }
}
