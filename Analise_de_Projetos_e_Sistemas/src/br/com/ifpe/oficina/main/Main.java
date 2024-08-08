package br.com.ifpe.oficina.main;

import br.com.ifpe.oficina.apresentation.GUIMenu;
import br.com.ifpe.oficina.entities.abstractclasses.Carpets;
import br.com.ifpe.oficina.entities.abstractclasses.IDecoratedCar;
import br.com.ifpe.oficina.entities.concreteclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.CarEngine;
import br.com.ifpe.oficina.utils.LoadEntity;

public class Main {
	public static void main(String[] args) {
		IDecoratedCar car = Car.CarBuilder.aCar()
				.plate("ABC")
				.traction("Traction")
				.engine(new CarEngine(200,100,"Combustão"))
				.build();
		System.out.println(car.toString());
		car = new Carpets(car);
		System.out.println(car.toString());
		LoadEntity.getInstance().createRandomData();;
		GUIMenu.runGUI();
	}
}