package dev.javatechie.stack;

import java.util.NoSuchElementException;

public class ArrayBasedStack {

    public static void main(String[] args) {
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

    }

    private Object[] items;

    private int size = 0;

    public ArrayBasedStack(int capacity) {
        items = new Object[capacity];
    }

    public void push(Object item) {
        if (size == items.length) {
            throw new IllegalStateException("We can't insert item anymore");
        }
        items[size++] = item;
    }

    public Object pop() {
        if (size == 0) {
            throw new NoSuchElementException("No item present in stack");
        }
        final Object item = items[size - 1];
        items[size - 1] = null;
        size--;
        return item;
    }

    public Object peek() {
        if (size == 0) {
            throw new NoSuchElementException("Empty stack");
        }
        return items[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printStackItems() {
        for (final Object item : items) {
            if(item != null)
                System.out.println(item);
        }
    }
}
