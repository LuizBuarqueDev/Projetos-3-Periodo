package br.ifpe.datastructures.nodes;

import br.ifpe.datastructures.abstractclass.BasicNode;

public class HuffmanNode extends BasicNode {
	
	private char character;
	private int frequency;
	
	public HuffmanNode(char character, int frequency) {
		super();
		this.character = character;
		this.frequency = frequency;
	}

	public HuffmanNode(HuffmanNode leftSon , HuffmanNode rightSon) {
		super();
		// TODO Auto-generated constructor stub
		this.frequency = leftSon.getFrequency() + rightSon.getFrequency();
		
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
}
