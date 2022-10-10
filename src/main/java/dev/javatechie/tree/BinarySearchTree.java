package dev.javatechie.tree;

public class BinarySearchTree<E extends Comparable<E>> {

    public static void main(String[] args) {
        System.out.println("=== Binary Search Tree ===");
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

    private int size = 0;
    private Node<E> root;

    public Node<E> addNewNode(final Node<E> rootNode, final E data) {
        return null;
    }

    public Node<E> getLeafNode(final Node<E> rootNode) {
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean isRoot(final Node<E> node) {
        if(root == node)
            return true;
        return false;
    }

    public boolean isLeaf(final Node<E> node) {
        return false;
    }
}
