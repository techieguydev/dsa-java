package dev.javatechie.queue;

import java.util.NoSuchElementException;

public class LinkedListBasedQueue {
    public static void main(String[] args) {

    }

    private static class Node {
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

}
