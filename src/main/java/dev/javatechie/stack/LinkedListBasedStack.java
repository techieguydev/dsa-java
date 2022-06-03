package dev.javatechie.stack;

import java.util.NoSuchElementException;

public class LinkedListBasedStack {

    public static void main(String[] args) {
        final LinkedListBasedStack linkedListStack = new LinkedListBasedStack();
        //linkedListStack.peek();
        linkedListStack.push("item1");
        linkedListStack.push("item2");
        linkedListStack.push("item3");

        linkedListStack.printStack();
        System.out.println(linkedListStack.size());
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.size());
    }

    private static class Node {
        private Object item;
        private Node next;

        public Node(final Object item, final Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node top = null;
    private int size = 0;

    public void push(final Object item) {
        top = new Node(item, top);
        size++;
    }

    public Object pop() {
        if (top == null) {
            throw new IllegalStateException("Empty stack");
        }
        final Object item = peek();
        top = top.next;
        size--;
        return item;
    }

    public Object peek() {
        if (top == null) {
            throw new NoSuchElementException("Empty stack");
        }
        return top.item;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printStack() {
        for (Node node = top; node != null; node = node.next) {
            System.out.println(node.item);
        }
    }
}
