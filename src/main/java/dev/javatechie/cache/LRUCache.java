package dev.javatechie.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private final Map<K, Map.Entry<K, V>> data = new HashMap<>();
    private Map.Entry<K, V> head;
    private Map.Entry<K, V> tail;

}
