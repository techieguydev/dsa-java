package dev.javatechie.tree;

public class BinaryTree<E extends Comparable<E>> {

    public static void main(String[] args) {

    }

    private Node<E> root;
    private int size = 0;

    public void addNode(final E element) {
        if (root == null) {
            root = new Node<>(element);
            size++;
        } else {
            addNode(root, element);
        }
    }

    private Node<E> addNode(final Node<E> rootNode, final E element) {
        if (rootNode == null) {
            return null;
        }

        final Node<E> newNode = new Node<>(element);
        if(newNode.data.compareTo(rootNode.data) <= 0) {
            if(rootNode.left != null) {
                rootNode.left = addNode(rootNode, element);
            } else {
                rootNode.left = newNode;
            }
        } else {
            if(rootNode.right != null) {
                rootNode.right = addNode(rootNode, element);
            } else {
                rootNode.right = newNode;
            }
        }
        size++;
        return newNode;
    }

    private static class Node<T> {
        private Node<T> left;
        private Node<T> right;
        private T data;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
