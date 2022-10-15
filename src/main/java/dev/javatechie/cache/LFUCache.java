package dev.javatechie.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Lfu cache.
 *
 * @param <K> the key type parameter
 * @param <V> the value type parameter
 */
public class LFUCache<K, V> {

    private class Node {
        private K key;
        private V value;
        private int frequency;
        private Node previous;
        private Node next;

        /**
         * Instantiates a new Node.
         */
        public Node() {

        }

        /**
         * Instantiates a new Node.
         *
         * @param key       the key
         * @param value     the value
         * @param frequency the frequency
         */
        public Node(final K key, final V value, int frequency) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }
    }

    private Node head;
    private Node tail;
    private Map<K, Node> map = null;
    private Integer capacity;
    private static final int DEFAULT_CAPACITY = 100;

    /**
     * Instantiates a new Lfu cache.
     */
    public LFUCache() {
        this.capacity = DEFAULT_CAPACITY;
    }

    /**
     * Instantiates a new Lfu cache.
     *
     * @param capacity the capacity
     */
    public LFUCache(final Integer capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public V get(final K key) {
        if(this.map.get(key) == null) {
            return null;
        }
    }
}
