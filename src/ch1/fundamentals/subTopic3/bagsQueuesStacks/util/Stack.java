package ch1.fundamentals.subTopic3.bagsQueuesStacks.util;

import java.util.Iterator;

/**
 * @author Sumit Deo
 */
public interface Stack<T> extends Iterable<T> {

    public int size();

    public boolean isEmpty();

    public void push(T elem);

    public T peek();

    public T pop();

    @Override
    Iterator<T> iterator();
}
