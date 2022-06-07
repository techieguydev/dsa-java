package dev.javatechie.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree<E extends Comparable<E>> {
    public static void main(String[] args) {


    }

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
