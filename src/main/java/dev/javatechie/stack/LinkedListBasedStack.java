package dev.javatechie.stack;

import java.util.NoSuchElementException;

/**
 * The type Linked list based stack.
 */
public class LinkedListBasedStack {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("=== LinkedList Based Stack");
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

        /**
         * Instantiates a new Node.
         *
         * @param item the item
         * @param next the next
         */
        public Node(final Object item, final Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node top = null;
    private int size = 0;

    /**
     * Push.
     *
     * @param item the item
     */
    public void push(final Object item) {
        top = new Node(item, top);
        size++;
    }

    /**
     * Pop object.
     *
     * @return the object
     */
    public Object pop() {
        if (top == null) {
            throw new IllegalStateException("Empty stack");
        }
        final Object item = peek();
        top = top.next;
        size--;
        return item;
    }

    /**
     * Peek object.
     *
     * @return the object
     */
    public Object peek() {
        if (top == null) {
            throw new NoSuchElementException("Empty stack");
        }
        return top.item;
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return this.size;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Print stack.
     */
    public void printStack() {
        for (Node node = top; node != null; node = node.next) {
            System.out.println(node.item);
        }
    }
}
