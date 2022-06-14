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
}
