package br.com.ifpe.oficina.interfaces;

import br.com.ifpe.oficina.entities.abstractclasses.Car;

public interface IController {
	
	Car searchCar(String plate);
}
