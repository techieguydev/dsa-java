package dev.javatechie.stack;

public class LinkedListBasedStack {

    public static void main(String[] args) {

    }

    private class Node {
        private Object item;
        private Node next;

        public Node(final Object item, final Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node top = null;

    public void push(final Object item) {
        top = new Node(item, top);
    }

    public Object pop() {
        if (top == null) {
            throw new IllegalStateException("Empty stack");
        }
        final Object item = peek();
        top = top.next;
        return item;
    }
}
