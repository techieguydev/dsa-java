package dev.javatechie.tree;

public class BinarySearchTree<E extends Comparable<E>> {

    public static void main(String[] args) {

    }

    private class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(final T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node<E> addNewNode(final Node<E> rootNode, final E data) {
        return null;
    }

    public Node<E> getLeafNode(final Node<E> rootNode) {
        return null;
    }
}
