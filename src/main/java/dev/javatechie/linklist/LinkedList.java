package dev.javatechie.linklist;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * The type Linked list.
 */
public class LinkedList {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("=== LinkedList Start");

        final List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");

        Instant listStart = Instant.now();
        for(String element : list) {
            System.out.println(element);
        }
        Instant listEnd = Instant.now();
        System.out.println(Duration.between(listStart, listEnd));

        Instant start = Instant.now();
        list.parallelStream().forEach(s -> System.out.println(s));
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));

    }
}
