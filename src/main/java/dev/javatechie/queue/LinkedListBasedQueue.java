package dev.javatechie.queue;

import java.util.NoSuchElementException;

public class LinkedListBasedQueue {
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

        public Node(final Object item, final Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

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

    public Object peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Queue");
        }
        return head.item;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void printQueue() {
        for (Node node = head; node != null; node = node.next) {
            System.out.println(node.item);
        }
    }
}
