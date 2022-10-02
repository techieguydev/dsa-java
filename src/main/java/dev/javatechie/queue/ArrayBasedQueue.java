package dev.javatechie.queue;

import java.util.NoSuchElementException;

/**
 * The type Array based queue.
 *
 * @author TechieGuy
 */
public class ArrayBasedQueue {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("");
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

    /**
     * Instantiates a new Array based queue.
     *
     * @param capacity the capacity
     */
    public ArrayBasedQueue(int capacity) {
        items = new Object[capacity];
    }

    /**
     * Enqueue.
     *
     * @param item the item
     */
    public void enqueue(final Object item) {
        if (size == items.length) {
            throw new IllegalStateException("No space to add more item into Queue");
        }
        items[tail] = item;
        tail = (tail + 1) % items.length;
        size++;
    }

    /**
     * Dequeue object.
     *
     * @return the object
     */
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

    /**
     * Peek object.
     *
     * @return the object
     */
    public Object peek() {
        if(size == 0) {
            throw new NoSuchElementException("Empty Queue");
        }
        return items[head];
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return size;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
