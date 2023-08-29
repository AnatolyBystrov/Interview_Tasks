package telran.interviews;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MyStack<T> {

    private LinkedList<T> stack;
    private LinkedList<T> maxStack;
    private Comparator<T> comparator;

    public MyStack(Comparator<T> comp) {
        stack = new LinkedList<>();
        maxStack = new LinkedList<>();
        comparator = comp;
    }

    public MyStack() {
        stack = new LinkedList<>();
        maxStack = new LinkedList<>();
    }

    public void push(T element) {
        if (maxStack.isEmpty() || comparator.compare(element, maxStack.getFirst()) >= 0)
        {
            maxStack.addFirst(element);
        }
        else if (comparator.compare(element, maxStack.getFirst()) <= 0)
        {
            maxStack.addLast(element);
        }
        stack.addLast(element);
    }

    public void pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        System.out.println(stack.getLast());
        T remove = stack.removeLast();
        if (comparator.compare(remove, maxStack.getFirst()) == 0) {
            maxStack.removeFirst();
        }
    }

    public boolean isEmpty() {

        return stack.isEmpty();
    }

    public T getMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return maxStack.getFirst();
    }

    public T[] toArray() {
        return stack.toArray((T[]) new Object[size()]);
    }

    private int size() {
        return stack.size();
    }
}