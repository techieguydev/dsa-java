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
            Map.Entry<K, V> evicted = evict();
            data.remove(evicted.getKey());
        }
        this.cap = capacity;
    }

    private Map.Entry<K, V> evict() {
        if (head == null)
            throw new RuntimeException("Cache can't be empty");

        Map.Entry<K, V> evicted = head;
        head = evicted.getNextEntry();

        return null;
    }


    public void checkCapacity(final int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("Capacity should be greater than zero");
        }
    }

    static final class Entry<K, V> {
        private Entry<K, V> preEntry;
        private Entry<K, V> nextEntry;
        private K key;
        private V value;

        public Entry() {

        }

        public Entry(final Entry<K, V> preEntry, final Entry<K, V> nextEntry, final K key, final V value) {

        }
    }
}
