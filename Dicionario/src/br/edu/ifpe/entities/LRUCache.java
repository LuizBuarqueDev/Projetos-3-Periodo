package br.edu.ifpe.entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class LRUCache<K, V> {
    private int capacity;
    private LinkedList<K> accessOrder;
    private List<K> keys;
    private List<V> values;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.accessOrder = new LinkedList<>();
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    public void put(K key, V value) {
        int index = keys.indexOf(key);

        if (index != -1) {
            // Atualiza o valor existente
            values.set(index, value);
            updateAccessOrder(key);
        } else {
            // Adiciona uma nova entrada
            if (keys.size() >= capacity) {
                // Remove o item mais antigo
                K oldestKey = accessOrder.removeLast();
                int oldestIndex = keys.indexOf(oldestKey);
                keys.remove(oldestIndex);
                values.remove(oldestIndex);
            }
            keys.add(0, key);
            values.add(0, value);
            accessOrder.addFirst(key);
        }
    }

    public V get(K key) {
        int index = keys.indexOf(key);
        if (index != -1) {
            V value = values.get(index);
            updateAccessOrder(key);
            return value;
        }
        return null;
    }

    public void remove(K key) {
        int index = keys.indexOf(key);
        if (index != -1) {
            keys.remove(index);
            values.remove(index);
            accessOrder.remove(key);
        }
    }

    private void updateAccessOrder(K key) {
        accessOrder.remove(key);
        accessOrder.addFirst(key);
    }
}