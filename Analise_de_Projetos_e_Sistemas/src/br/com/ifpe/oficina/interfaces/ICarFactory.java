package br.com.ifpe.oficina.interfaces;

import br.com.ifpe.oficina.entities.abstractclasses.Car;

public interface ICarFactory {
	
	Car createCar(String plate, String chassis, int age);
}
