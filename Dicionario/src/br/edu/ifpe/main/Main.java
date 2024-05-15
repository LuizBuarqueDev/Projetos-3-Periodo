package br.edu.ifpe.main;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.put("C", 3);

        System.out.println("Valor associado à chave 'A': " + hashMap.get("A"));
        System.out.println("Valor associado à chave 'B': " + hashMap.get("B"));

        hashMap.remove("C");

        System.out.println("A chave 'C' existe no HashMap? " + hashMap.containsKey("C"));

        System.out.println("Conteúdo do HashMap: " + hashMap);
    }
}
