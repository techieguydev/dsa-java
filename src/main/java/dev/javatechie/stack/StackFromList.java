package dev.javatechie.stack;

import java.util.LinkedList;

/**
 * The type Stack from list.
 *
 * @param <T> the type parameter
 */
public class StackFromList<T> {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("=== List based stack ");
        final StackFromList<String> stack = new StackFromList<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");

        System.out.println(stack.pop());
        System.out.println("==== Print Stack ====");
        stack.printStack();

    }

    private LinkedList<T> list = new LinkedList<>();

    /**
     * Push.
     *
     * @param item the item
     */
    public void push(final T item) {
        list.addFirst(item);
    }

    /**
     * Pop t.
     *
     * @return the t
     */
    public T pop() {
        return list.removeFirst();
    }

    /**
     * Peek t.
     *
     * @return the t
     */
    public T peek() {
        return list.getFirst();
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return list.size();
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Print stack.
     */
    public void printStack() {
        for(T item : list) {
            System.out.println(item);
        }
    }
}
