package dev.javatechie.tree;

/**
 * The type Avl tree.
 *
 * @param <E> the type parameter
 * @author Qadir
 */
public class AVLTree<E> {
    /**
     * The entry point of the application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("=== AVL Tree Start");
    }

    /**
     * Node class of a Tree
     * @param <T> the type parameter
     *
     * */
    private class Node<T> {
        // data element
        private T data;
        // Left node of a tree
        private Node<T> left;
        // Right node of a tree
        private Node<T> right;

        /**
         * Instantiates a new Node.
         *
         * @param data the data
         */
        public Node(final T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Add node.
     *
     * @param data the data
     */
    public void addNode(final E data) {

    }
}
