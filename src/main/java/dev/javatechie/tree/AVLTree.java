package dev.javatechie.tree;

public class AVLTree<E> {
    public static void main(String[] args) {


    }

    private class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(final T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
