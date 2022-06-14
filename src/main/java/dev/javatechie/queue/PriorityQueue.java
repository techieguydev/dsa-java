package dev.javatechie.queue;

public class PriorityQueue<E extends Comparable<E>> {
    public static void main(String[] args) {

    }

    private class Node<T> {
        private T data;
        private Node next;

        public Node(final T data) {
            this.data = data;
            this.next = null;
        }
    }

    private int size = 0;
    private Node<E> tail;
    private Node<E> head;

    private int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private

}
