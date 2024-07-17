package br.com.ifpe.oficina.main;

import br.com.ifpe.oficina.apresentation.GUIMenu;
import br.com.ifpe.oficina.utils.LoadEntity;

public class Main {
	public static void main(String[] args) {
		LoadEntity.getinstance().createRandomData();;
		GUIMenu.runGUI();
	}
}
