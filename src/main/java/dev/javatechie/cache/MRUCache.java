package dev.javatechie.cache;

import java.util.HashMap;
import java.util.Map;

public class MRUCache<K, V> {

    private final Map<K, Entry<K, V>> data = new HashMap<>();
    private Entry<K, V> head;
    private Entry<K, V> tail;
    private int cap;
    private static final int DEFAULT_CAP = 100;

    public MRUCache() {
        setCapacity(DEFAULT_CAP);
    }

    private void setCapacity(int newCapacity) {
        checkCapacity(newCapacity);
        for(int i = data.size(); i > newCapacity; i--) {
            Entry<K, V> evicted = evict();
            data.remove(evicted.getKey());
        }
        this.cap = newCapacity;
    }

    private void checkCapacity(int capacity) {
        if(capacity <= 0) {
            throw new RuntimeException("Capacity must be greater than zero!");
        }
    }

    private Entry<K, V> evict() {
        if
    }
}
