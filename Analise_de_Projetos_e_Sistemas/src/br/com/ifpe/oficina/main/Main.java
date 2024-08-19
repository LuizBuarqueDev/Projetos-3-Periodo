package br.com.ifpe.oficina.main;

import br.com.ifpe.oficina.presentation.GUIMenu;
import br.com.ifpe.oficina.utils.LoadEntity;

public class Main {
	public static void main(String[] args) {
		LoadEntity.getInstance().createRandomData(50);
		GUIMenu.runGUI();
	}
}