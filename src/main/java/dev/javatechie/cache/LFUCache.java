package dev.javatechie.cache;

public class LFUCache<K, V> {

    private class Node {
        private K key;
        private V value;
        private int frequency;

    }
}
