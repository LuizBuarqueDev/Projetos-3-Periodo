package br.com.ifpe.oficina.entities.decorator;

import br.com.ifpe.oficina.entities.concreteclasses.Car;

public interface IBasicCar {
    Car getInnerCar();
    double getPrice();
}
