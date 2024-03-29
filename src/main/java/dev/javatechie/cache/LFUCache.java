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

    /**
     * Get v.
     *
     * @param key the key param
     * @return the value
     */
    public V get(final K key) {
        if(this.map.get(key) == null) {
            return null;
        }

        final Node node = map.get(key);
        removeNode(node);
        node.frequency += 1;
        addNodeWithUpdatedFrequency(node);

        return node.value;
    }

    /**
     * Put.
     *
     * @param key   the key
     * @param value the value
     */
    public void put(final K key, final V value) {
        if(map.containsKey(key)) {
            final Node node = map.get(key);
            node.value = value;
            node.frequency += 1;
            removeNode(node);
            addNodeWithUpdatedFrequency(node);
        } else {
            if (map.size() >= capacity) {
                map.remove(this.head.key);
                removeNode(head);
            }
            final Node node = new Node(key, value, 1);
            addNodeWithUpdatedFrequency(node);
            map.put(key, node);
        }
    }

    private void addNodeWithUpdatedFrequency(final Node node) {
        if(tail != null && head != null) {
            Node temp = this.head;
            while (temp != null) {
                if(temp.frequency > node.frequency) {
                    if(temp == head) {
                        node.next = temp;
                        temp.previous = node;
                        this.head = node;
                        break;
                    } else {
                        node.next = temp;
                        node.previous = temp.previous;
                        temp.previous.next = node;
                        node.previous = temp.previous;
                        break;
                    }
                } else {
                    temp = temp.next;
                    if(temp == null) {
                        tail.next = node;
                        node.previous = tail;
                        node.next = null;
                        tail = node;
                        break;
                    }
                }
            }
        } else {
            tail = node;
            head = tail;
        }
    }

    private void removeNode(final Node node) {
        if(node.previous != null) {
            node.previous.next = node.next;
        } else {
            this.head = node.next;
        }
        if(node.next != null) {
            node.next.previous = node.previous;
        } else {
            this.tail = node.previous;
        }
    }
}
