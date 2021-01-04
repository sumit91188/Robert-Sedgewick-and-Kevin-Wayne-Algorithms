package fundamentals.bagsQueuesStacks.util;

import java.util.Iterator;

/**
 * @author Sumit Deo
 */
public interface Queue<T> extends Iterable<T> {

    T poll();

    T peek();

    int size();

    boolean isEmpty();

    void offer(T elem);

    @Override
    Iterator<T> iterator();
}
