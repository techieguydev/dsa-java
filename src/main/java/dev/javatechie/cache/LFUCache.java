package dev.javatechie.cache;

import java.util.Map;

public class LFUCache<K, V> {

    private class Node {
        private K key;
        private V value;
        private int frequency;
        private Node previous;
        private Node next;

        public Node() {

        }

        public Node(final K key, final V value, int frequency) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }

        private Node head;
        private Node tail;
        private Map<K, Node> map = null;

    }
}
