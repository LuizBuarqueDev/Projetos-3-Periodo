package br.com.ifpe.oficina.services.controllers;

import br.com.ifpe.oficina.entities.decorator.IBasicCar;

public interface ICarController {
    IBasicCar applyAccessories(IBasicCar car, int carpets, int seats);
}
