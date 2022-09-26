package dev.javatechie.stack;

import java.util.NoSuchElementException;

/**
 * The type Array based stack.
 */
public class ArrayBasedStack {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("=== ");
        ArrayBasedStack stack = new ArrayBasedStack(10);
        stack.push("Item1");
        stack.push("Item2");
        stack.push("Item3");
        stack.push("Item4");
        System.out.println(stack.size());
        stack.printStackItems();

        stack.pop();
        stack.pop();

        System.out.println(stack.size());
        stack.printStackItems();

        System.out.println(stack.isEmpty());

        System.out.println(stack.peek());

    }

    private Object[] items;

    private int size = 0;

    /**
     * Instantiates a new Array based stack.
     *
     * @param capacity the capacity
     */
    public ArrayBasedStack(int capacity) {
        items = new Object[capacity];
    }

    /**
     * Push.
     *
     * @param item the item
     */
    public void push(Object item) {
        if (size == items.length) {
            throw new IllegalStateException("We can't insert item anymore");
        }
        items[size++] = item;
    }

    /**
     * Pop object.
     *
     * @return the object
     */
    public Object pop() {
        if (size == 0) {
            throw new NoSuchElementException("No item present in stack");
        }
        final Object item = items[size - 1];
        items[size - 1] = null;
        size--;
        return item;
    }

    /**
     * Peek object.
     *
     * @return the object
     */
    public Object peek() {
        if (size == 0) {
            throw new NoSuchElementException("Empty stack");
        }
        return items[size - 1];
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

    /**
     * Print stack items.
     */
    public void printStackItems() {
        for (final Object item : items) {
            if(item != null)
                System.out.println(item);
        }
    }
}
