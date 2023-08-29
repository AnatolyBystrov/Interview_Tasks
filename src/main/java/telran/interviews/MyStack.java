package telran.interviews;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MyStack<T> {

    LinkedList<T> values = new LinkedList<>();
    LinkedList<T> maxValues = new LinkedList<>();
    Comparator<T> comp;
    public MyStack(Comparator<T> comp) {
        this.comp = comp;
    }
    @SuppressWarnings("unchecked")
    public MyStack() {
        this((Comparator<T>)Comparator.naturalOrder());
    }

    public void push(T element) {
        values.add(element);
        if(maxValues.isEmpty() || comp.compare(element,maxValues.getLast()) >= 0) {
            maxValues.add(element);
        }

    }
    public T pop() {
        T element = values.removeLast();
        if (comp.compare(element, maxValues.getLast()) == 0) {
            maxValues.removeLast();
        }
        return element;
    }
    public boolean isEmpty() {

        return values.isEmpty();
    }
    public T getMax() {
        return maxValues.getLast();
    }


    public T[] toArray() {
        return values.toArray((T[]) new Object[size()]);
    }

    private int size() {
        return values.size();
    }
}