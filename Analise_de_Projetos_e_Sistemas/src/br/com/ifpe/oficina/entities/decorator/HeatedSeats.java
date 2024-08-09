package br.com.ifpe.oficina.entities.decorator;

import br.com.ifpe.oficina.entities.concreteclasses.CarEngine;
import br.com.ifpe.oficina.entities.concreteclasses.Client;

public class HeatedSeats implements IBasicCar {

    private final IBasicCar car;

    public HeatedSeats(IBasicCar car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return car.toString().replaceFirst(", Total price with accessories: \\d+\\.\\d+", "") +
                ", Total price with accessories: " + getBasePrice();
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
    public double getBasePrice() {
        // Retorna o preço do carro decorado, somando o preço do acessório atual
        double accessoryPrice = 2000;
        return this.car.getBasePrice() + accessoryPrice;
    }
}