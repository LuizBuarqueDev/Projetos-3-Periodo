package br.ifpe.datastructures.abstractclass;

public abstract class BasicNode {
	
	private BasicNode leftSon;
	private BasicNode rightSon;
	private BasicNode father;
	
	public BasicNode() {
		super();
		this.leftSon = null;
		this.rightSon = null;
		this.father = null;
	}

	public BasicNode getLeftSon() {
		return leftSon;
	}

	public void setLeftSon(BasicNode leftSon) {
		this.leftSon = leftSon;
	}

	public BasicNode getRightSon() {
		return rightSon;
	}

	public void setRightSon(BasicNode rightSon) {
		this.rightSon = rightSon;
	}

	public BasicNode getFather() {
		return father;
	}

	public void setFather(BasicNode father) {
		this.father = father;
	}
}
