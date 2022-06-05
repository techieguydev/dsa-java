package dev.javatechie.queue;

import java.util.NoSuchElementException;

/**
 * The type Linked list based queue.
 */
public class LinkedListBasedQueue {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        final LinkedListBasedQueue linkedListQueue = new LinkedListBasedQueue();
        linkedListQueue.enqueue("Item1");
        linkedListQueue.enqueue("Item2");
        linkedListQueue.enqueue("Item3");

        System.out.println(linkedListQueue.size());
        linkedListQueue.printQueue();
        linkedListQueue.dequeue();
        System.out.println(linkedListQueue.size());
        linkedListQueue.printQueue();

    }

    private class Node {
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

    private Node head;
    private Node tail;
    private int size = 0;

    /**
     * Enqueue.
     *
     * @param item the item
     */
    public void enqueue(final Object item) {
        final Node newNode = new Node(item, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    /**
     * Dequeue object.
     *
     * @return the object
     */
    public Object dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Queue");
        }
        final Object item = peek();
        if (tail == head) {
            tail = null;
        }
        head = head.next;
        size--;
        return item;
    }

    /**
     * Peek object.
     *
     * @return the object
     */
    public Object peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Queue");
        }
        return head.item;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return head == null;
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
     * Print queue.
     */
    public void printQueue() {
        for (Node node = head; node != null; node = node.next) {
            System.out.println(node.item);
        }
    }
}
