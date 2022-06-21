package dev.javatechie.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private final Map<K, Map.Entry<K, V>> data = new HashMap<>();
    private Map.Entry<K, V> head;
    private Map.Entry<K, V> tail;
    private int cap;
    private static final int DEFAULT_CAP = 100;

    public LRUCache() {

    }
    public LRUCache(int cap) {

    }

    public void setCapacity(final int capacity) {
        checkCapacity(capacity);
        for (int size = data.size(); size > capacity; size--) {

        }
    }

    public void checkCapacity(final int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("Capacity should be greater than zero");
        }
    }
}
