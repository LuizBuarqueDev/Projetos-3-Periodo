package br.com.ifpe.oficina.main;

import br.com.ifpe.oficina.apresentation.GUIMenu;
import br.com.ifpe.oficina.entities.concreteclasses.Client;
import br.com.ifpe.oficina.entities.decorator.Carpets;
import br.com.ifpe.oficina.entities.decorator.HeatedSeats;
import br.com.ifpe.oficina.entities.decorator.IBasicCar;
import br.com.ifpe.oficina.entities.concreteclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.CarEngine;
import br.com.ifpe.oficina.utils.LoadEntity;

public class Main {
	public static void main(String[] args) {
		IBasicCar car = Car.CarBuilder.aCar()
				.plate("ABC")
				.traction("Traction")
				.client(Client.ClientBuilder.aClient().build())
				.engine(new CarEngine(200,100,"Combustão"))
				.build();
		System.out.println(car.toString());
		car = new Carpets(car);
		System.out.println(car.toString());
		car = new HeatedSeats(car);
		System.out.println(car.toString());
		LoadEntity.getInstance().createRandomData();;
		GUIMenu.runGUI();
	}
}