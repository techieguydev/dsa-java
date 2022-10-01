package dev.javatechie.queue;

/**
 * The type Priority queue.
 *
 * @param <E> the type parameter
 */
public class PriorityQueue<E extends Comparable<E>> {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("===");
    }

    private class Node<T> {
        private T data;
        private Node next;

        /**
         * Instantiates a new Node.
         *
         * @param data the data
         */
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

    private void printPriorityQueue() {
        System.out.println("Printing PriorityQueue elements");
        while (head != null) {

        }
    }

}
