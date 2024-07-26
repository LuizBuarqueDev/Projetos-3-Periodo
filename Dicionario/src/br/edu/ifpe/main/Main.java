package br.edu.ifpe.main;

import br.edu.ifpe.entities.TabelaHash;
public class Main {
    public static void main(String[] args) {
    	
        TabelaHash<String, Integer> hashtable = new TabelaHash<String, Integer>();

        hashtable.put("A", 1);
        hashtable.put("B", 2);
        hashtable.put("C", 3);
        hashtable.put("D", 4);
        
        System.out.println("Valor associado à chave 'A': " + hashtable.get("A"));
        System.out.println("Valor associado à chave 'B': " + hashtable.get("B"));

        hashtable.remove("C");

        System.out.println("Conteúdo do hashtable: " + hashtable);
        
        TabelaHash<String, String> hashtableString = new TabelaHash<String, String>();
        
        hashtableString.put("A", "1");
        hashtableString.put("B", "2");
        hashtableString.put("C", "3");
        hashtableString.put("D", "4");
        hashtableString.put("D", "Fresco");
        
        hashtable.remove("C");
        
        System.out.println("Conteúdo do hashtable: " + hashtableString.toString());
    }
}
