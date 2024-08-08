package br.com.ifpe.oficina.entities.decorator;

import br.com.ifpe.oficina.entities.concreteclasses.CarEngine;
import br.com.ifpe.oficina.entities.concreteclasses.Client;

public interface IDecoratedCar {
    String getPlate();
    CarEngine getEngine();
    String getTraction();
    Client getClient();
    double getPrice();  // Cada carro e seus decoradores terão um preço
}
