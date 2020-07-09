package ch1.fundamentals.subTopic3.bagsQueuesStacks.util;

import java.util.Iterator;

/**
 * @author Sumit Deo
 */
public interface Queue<T> extends Iterable<T> {

    public T dequeue();

    public int size();

    public boolean isEmpty();

    public void enqueue(T elem);

    @Override
    Iterator<T> iterator();
}
