package br.com.ifpe.oficina.apresentation;

import br.com.ifpe.oficina.services.controllers.CarController;
import br.com.ifpe.oficina.services.controllers.ClientController;

public class Facade {
    CarController carController = CarController.getInstance();
    ClientController clientController = ClientController.getInstance();
    
}
