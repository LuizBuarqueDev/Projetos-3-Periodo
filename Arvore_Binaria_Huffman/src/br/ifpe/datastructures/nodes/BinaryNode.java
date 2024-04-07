package br.ifpe.datastructures.nodes;

import br.ifpe.datastructures.abstractclass.BasicNode;

public class BinaryNode extends BasicNode {
	
	private int value;

	public BinaryNode(int value) {
		super();
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}	
}
