package br.com.ifpe.oficina.main;

import br.com.ifpe.oficina.apresentation.GUIMenu;
import br.com.ifpe.oficina.entities.abstractclasses.Car;
import br.com.ifpe.oficina.entities.concreteclasses.WorkshopManager;
import br.com.ifpe.oficina.services.helper.LoadClientEntity;

public class Main {
	public static void main(String[] args) {
		LoadClientEntity.getinstance().createRandomData();
		for (Car car : WorkshopManager.getInstance().getCarList()) {
			System.out.println(car);
		}
		GUIMenu.runGUI();
		

	}
}
