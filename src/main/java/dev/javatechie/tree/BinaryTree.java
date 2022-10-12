package dev.javatechie.tree;

/**
 * The type Binary tree.
 *
 * @param <E> the type parameter
 */
public class BinaryTree<E extends Comparable<E>> {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("");
    }

    private Node<E> root;
    private int size = 0;

    /**
     * Add node.
     *
     * @param element the element
     */
    public void addNode(final E element) {
        if (root == null) {
            root = new Node<>(element);
            size++;
        } else {
            addNode(root, element);
        }
    }

    /**
     * Add node node.
     *
     * @param rootNode the root node
     * @param element  the element
     * @return the node
     */
    public Node<E> addNode(final Node<E> rootNode, final E element) {
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

    /**
     * Root node.
     *
     * @return the node
     */
    public Node<E> root() {
        if(!isEmpty())
            return root;
        return null;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Is root boolean.
     *
     * @param node the node
     * @return the boolean
     */
    public boolean isRoot(final Node<E> node ) {
        if (root == node) {
            return true;
        }
        return false;
    }

    private static class Node<T> {
        private Node<T> left;
        private Node<T> right;
        private T data;

        /**
         * Instantiates a new Node.
         *
         * @param data the data
         */
        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
