package br.edu.ifpe.entities;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache<K, V> {
    private LinkedHashMap<K, V> cache;
    private LinkedList<K> accessOrder;

    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {

            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
        this.accessOrder = new LinkedList<>();
    }

    public void put(K key, V value) {
        cache.put(key, value);
        updateAccessOrder(key);
    }

    public V get(K key) {
        V value = cache.getOrDefault(key, null);
        if (value != null) {
            updateAccessOrder(key);
        }
        return value;
    }

    public void remove(K key) {
        cache.remove(key);
        accessOrder.remove(key);
    }

    private void updateAccessOrder(K key) {
        accessOrder.remove(key);
        accessOrder.addFirst(key);
    }
}
