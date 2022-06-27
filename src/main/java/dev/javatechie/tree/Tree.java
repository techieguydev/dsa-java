package dev.javatechie.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree<E extends Comparable<E>> {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {


    }

    /**
     * Add node.
     *
     * @param node the node
     * @param data the data
     */
    public void addNode(final Node<E> node, final E data) {

    }

    private class Node<T> {
        private T data;
        private List<Node<T>> children;

        public Node(final T data) {
            this.data = data;
            children = new ArrayList<>();
        }
    }
}
