package dev.javatechie.queue;

import java.util.NoSuchElementException;

public class ArrayBasedQueue {
    public static void main(String[] args) {
        final ArrayBasedQueue queue = new ArrayBasedQueue(10);
        System.out.println(queue.size());

        queue.enqueue("Item1");
        queue.enqueue("Item2");
        queue.enqueue("Item3");

        System.out.println(queue.size());

        queue.dequeue();
        System.out.println(queue.size());

        System.out.println(queue.isEmpty());
    }

    private Object[] items;
    private int size = 0;

    private int tail = 0;
    private int head = 0;

    public ArrayBasedQueue(int capacity) {
        items = new Object[capacity];
    }

    public void enqueue(final Object item) {
        if (size == items.length) {
            throw new IllegalStateException("No space to add more item into Queue");
        }
        items[tail] = item;
        tail = (tail + 1) % items.length;
        size++;
    }

    public Object dequeue() {
        if(size == 0) {
            throw new NoSuchElementException("Empty Queue");
        }
        Object item = peek();
        items[head] = null;
        head = (head + 1) % items.length;
        size--;
        return item;
    }

    public Object peek() {
        if(size == 0) {
            throw new NoSuchElementException("Empty Queue");
        }
        return items[head];
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
