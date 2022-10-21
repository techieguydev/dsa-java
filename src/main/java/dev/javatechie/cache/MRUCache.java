package dev.javatechie.cache;

import java.util.HashMap;
import java.util.Map;

public class MRUCache<K, V> {

    private final Map<K, Entry<K, V>> data = new HashMap<>();
    private Entry<K, V> head;
    private Entry<K, V> tail;
    private int cap;
}
