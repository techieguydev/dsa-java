package dev.javatechie.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;

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
        if(head == null) {
            throw new RuntimeException("Cache cannot be empty");
        }
        final Entry<K, V> evicted = this.tail;
        tail = evicted.getPreEntry();
        tail.setNextEntry(null);
        evicted.setNextEntry(null);

        return evicted;
    }

    public MRUCache(int cap) {
        setCapacity(cap);
    }

    public V get(final K key) {
        if(!data.containsKey(key)) {
            return null;
        }
        final Entry<K, V> entry = data.get(key);
        moveEntryToLast(entry);
        return entry.getValue();
    }

    public void put(final K key, final V value) {
        if(data.containsKey(key)) {
            final Entry<K, V> existringEntry = data.get(key);
            existringEntry.setValue(value);
            moveEntryToLast(existringEntry);
            return;
        }
        Entry<K, V> newEntry;
        if (data.size() == cap) {
            newEntry = evict();
            data.remove(newEntry.getKey());
        } else {
            newEntry = new Entry<K, V>();
        }
        newEntry.setKey(key);
        newEntry.setValue(value);
        addNewEntry(newEntry);
        data.put(key, newEntry);
    }

    private void moveEntryToLast(final Entry<K,V> entry) {
        if(tail == entry) {
            return;
        }

        final Entry<K, V> preEntry = entry.getPreEntry();
        final Entry<K, V> nextEntry = entry.getNextEntry();
        if(preEntry != null) {
            preEntry.setNextEntry(nextEntry);
        }
        if(nextEntry != null) {
            nextEntry.setPreEntry(nextEntry);
        }
        if(head == entry) {
            head = nextEntry;
        }

        tail.setNextEntry(entry);
        entry.setPreEntry(tail);
        entry.setNextEntry(null);
    }

    private void addNewEntry(final Entry<K, V> entry) {
        if(data.isEmpty()) {
            head = entry;
            tail = entry;
            return;
        }

    }

    static final class Entry<I, J> {
        private Entry<I, J> preEntry;
        private Entry<I, J> nextEntry;
        private I key;
        private J value;

        public Entry() {}

        public Entry(final Entry<I, J> preEntry, final Entry<I, J> nextEntry, final I key, final J value) {
            this.preEntry = preEntry;
            this.nextEntry = nextEntry;
            this.key = key;
            this.value = value;
        }

        public Entry<I, J> getPreEntry() {
            return preEntry;
        }

        public void setPreEntry(final Entry<I, J> preEntry) {
            this.preEntry = preEntry;
        }

        public Entry<I, J> getNextEntry() {
            return nextEntry;
        }

        public void setNextEntry(final Entry<I, J> nextEntry) {
            this.nextEntry = nextEntry;
        }

        public I getKey() {
            return key;
        }

        public void setKey(final I key) {
            this.key = key;
        }

        public J getValue() {
            return value;
        }

        public void setValue(final J value) {
            this.value = value;
        }
    }
}
