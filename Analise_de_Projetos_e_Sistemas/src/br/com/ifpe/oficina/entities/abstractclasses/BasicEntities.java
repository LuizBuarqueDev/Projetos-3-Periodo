package br.com.ifpe.oficina.entities.abstractclasses;

public abstract class BasicEntities {
	
	private static int nextID;
	private int id;
	
	public BasicEntities() {
		this.id = nextID;
		nextID++;
	}

	public int getId() {
		return id;
	}
}
