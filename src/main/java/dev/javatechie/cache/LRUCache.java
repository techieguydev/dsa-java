package dev.javatechie.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private final Map<K, Entry<K, V>> data = new HashMap<>();
    private Entry<K, V> head;
    private Entry<K, V> tail;
    private int cap;
    private static final int DEFAULT_CAP = 100;

    public LRUCache() {

    }
    public LRUCache(int cap) {

    }

    public void setCapacity(final int capacity) {
        checkCapacity(capacity);
        for (int size = data.size(); size > capacity; size--) {
            final Entry<K, V> evicted = evict();
            data.remove(evicted.getKey());
        }

        this.cap = capacity;
    }

    private Entry<K, V> evict() {
        if (head == null)
            throw new RuntimeException("Cache can't be empty");

        final Entry<K, V> evicted = head;
        head = evicted.getNextEntry();
        head.setPreEntry(null);
        evicted.setNextEntry(null);

        return evicted;
    }


    private void checkCapacity(final int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("Capacity should be greater than zero");
        }

    }

    public V get(final K key) {
        if(!data.containsKey(key)) {
            return null;
        }
        final Entry<K, V> entry = data.get(key);
        moveNodeToLast(entry);
        return entry.getValue();
    }

    private void moveNodeToLast(final Entry<K, V> entry) {
        if(tail == entry) {
            return;
        }

        final Entry<K, V> preEntry = entry.getPreEntry();
        final Entry<K, V> nextEntry = entry.getNextEntry();
        if(preEntry != null) {
            preEntry.setNextEntry(nextEntry);
        }

        if(nextEntry != null) {
            nextEntry.setPreEntry(preEntry);
        }
        if(head == entry) {
            head = nextEntry;
        }

        tail.setNextEntry(entry);
        entry.setPreEntry(tail);
        entry.setNextEntry(null);
        tail = entry;
    }

    public void put(final K key, final V value) {
        if (data.containsKey(key)) {
            final Entry<K, V> existingEntry = data.get(key);
            existingEntry.setValue(value);
            moveNodeToLast(existingEntry);
            return;
        }
    }

    /**
     * The type Entry.
     *
     * @param <K> the type parameter
     * @param <V> the type parameter
     */
    static final class Entry<K, V> {
        private Entry<K, V> preEntry;
        private Entry<K, V> nextEntry;
        private K key;
        private V value;

        public Entry() {

        }

        /**
         * Instantiates a new Entry.
         *
         * @param preEntry  the pre entry
         * @param nextEntry the next entry
         * @param key       the key
         * @param value     the value
         */
        public Entry(final Entry<K, V> preEntry, final Entry<K, V> nextEntry, final K key, final V value) {
            this.preEntry = preEntry;
            this.nextEntry = nextEntry;
            this.key = key;
            this.value = value;
        }

        /**
         * Gets pre entry.
         *
         * @return the pre entry
         */
        public Entry<K, V> getPreEntry() {
            return preEntry;
        }

        /**
         * Sets pre entry.
         *
         * @param preEntry the pre entry
         */
        public void setPreEntry(Entry<K, V> preEntry) {
            this.preEntry = preEntry;
        }

        /**
         * Gets next entry.
         *
         * @return the next entry
         */
        public Entry<K, V> getNextEntry() {
            return nextEntry;
        }

        /**
         * Sets next entry.
         *
         * @param nextEntry the next entry
         */
        public void setNextEntry(Entry<K, V> nextEntry) {
            this.nextEntry = nextEntry;
        }

        /**
         * Gets key.
         *
         * @return the key
         */
        public K getKey() {
            return key;
        }

        /**
         * Sets key.
         *
         * @param key the key
         */
        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

    }
}
