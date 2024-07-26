package br.edu.ifpe.main;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>();

        hashtable.put("A", 1);
        hashtable.put("B", 2);
        hashtable.put("C", 3);
        hashtable.put("D", 4);
        
        System.out.println("Valor associado à chave 'A': " + hashtable.get("A"));
        System.out.println("Valor associado à chave 'B': " + hashtable.get("B"));

        hashtable.remove("C");

        System.out.println("A chave 'C' existe no hashtable? " + hashtable.containsKey("C"));

        System.out.println("Conteúdo do hashtable: " + hashtable);
    }
}
