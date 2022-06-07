package dev.javatechie.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    public static void main(String[] args) {

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
