package dev.javatechie.stack;

import java.util.LinkedList;

public class StackFromList<T> {

    public static void main(String[] args) {
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

    public void push(final T item) {
        list.addFirst(item);
    }

    public T pop() {
        return list.removeFirst();
    }

    public T peek() {
        return list.getFirst();
    }

    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void printStack() {
        for(T item : list) {
            System.out.println(item);
        }
    }
}
