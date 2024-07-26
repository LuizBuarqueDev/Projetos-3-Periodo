package br.edu.ifpe.entities;

import java.util.LinkedList;

public class TabelaHash<K, V> {
    private static final int defealtCapacity = 16;
    private LinkedList<Entry<K, V>>[] table;
    private int size;
    private LRUCache<K, Boolean> lruCache;

    public TabelaHash(int capacity) {
        this.table = new LinkedList[capacity];
        this.size = 0;
        this.lruCache = new LRUCache<>(capacity);
    }

    public TabelaHash() {
        this(defealtCapacity);
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        table[index].add(new Entry<>(key, value));
        size++;
        lruCache.put(key, true); // Atualiza o LRU quando um novo elemento é inserido
    }

    public V get(K key) {
        lruCache.get(key); // Atualiza o LRU quando um elemento é acessado
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            table[index].removeIf(entry -> entry.getKey().equals(key));
            size--;
            lruCache.remove(key); // Atualiza o LRU quando um elemento é removido
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    private static class Entry<K, V> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TabelaHash:\n");
        for (LinkedList<Entry<K, V>> bucket : table) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    sb.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
                }
            }
        }
        return sb.toString();
    }
}