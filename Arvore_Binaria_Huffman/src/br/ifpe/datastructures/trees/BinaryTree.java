package br.ifpe.datastructures.trees;

import br.ifpe.datastructures.abstractclass.BasicTree;
import br.ifpe.datastructures.nodes.BinaryNode;

public class BinaryTree extends BasicTree{
	
	private BinaryNode addRecursively(BinaryNode tempNode,int value) {
		if (tempNode == null) {
			return new BinaryNode(value);
			
		} else if (value < tempNode.getValue()) {
			tempNode.setLeftSon(addRecursively((BinaryNode) tempNode.getLeftSon(), value));
			
		} else {
			tempNode.setRightSon(addRecursively((BinaryNode) tempNode.getRightSon(), value));
			
		}
		return tempNode;
		
	}
	
	private String printNodePath (int value) {
		String path = "";
		String binaryCode = "";
		BinaryNode tempNode = (BinaryNode) getRootNode();
		
		while (tempNode != null) {
			if(value < tempNode.getValue()) {
				binaryCode += "0";
				tempNode = (BinaryNode) tempNode.getLeftSon();
				
			} else if (value > tempNode.getValue()) {
				binaryCode += "1";
				tempNode = (BinaryNode) tempNode.getRightSon();
				
			} else {
				return "Caminho até o elemento: " + value + ": " + path + "Codigo binario: " + binaryCode;
				
			}
			
		}
		return "O " + value + "não esta presente na arvore binaria";
		
	}
	
	@Override
	public String addNode(String value) {
		try {
			int intValue = Integer.parseInt(value);
			setRootNode(addRecursively((BinaryNode) getRootNode(),intValue));
			return value + "Foi adicinado";
			
		} catch (Exception e) {
			throw new NumberFormatException("Valor " + value + "não é valido");
		}
	}

	@Override
	public String getNode(String value) {
		try {
			int intValue = Integer.parseInt(value);
			return printNodePath(intValue);
			
		} catch (Exception e) {
			throw new NumberFormatException("Valor " + value + "não é valido");
		}
	}
}
