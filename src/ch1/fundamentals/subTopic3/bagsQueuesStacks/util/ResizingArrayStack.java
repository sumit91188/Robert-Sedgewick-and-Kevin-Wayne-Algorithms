package ch1.fundamentals.subTopic3.bagsQueuesStacks.util;

import java.util.Iterator;

/**
 * @author Sumit Deo
 */
public class ResizingArrayStack<T> implements Stack<T> {

    int maxNumElms = 1;
    int numElms;
    T[] array;

    public ResizingArrayStack() {
        numElms = 0;
        array = (T[]) new Object[maxNumElms];
    }

    @Override
    public int size() {
        return numElms;
    }

    @Override
    public boolean isEmpty() {
        return numElms == 0;
    }

    private void resize() {
        T[] temp = (T[]) new Object[maxNumElms];
        for(int i = 0; i < numElms; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    @Override
    public void push(T elem) {
        if (numElms == maxNumElms) {
            maxNumElms *= 2;
            resize();
        }
        array[numElms++] = elem;
    }

    @Override
    public T peek() {
        if (! isEmpty()) {
            return array[numElms - 1];
        }
        return null;
    }

    @Override
    public T pop() {
        T elm = array[--numElms];
        array[numElms] = null;
        if (numElms > 0 && numElms == maxNumElms / 4) {
            maxNumElms /= 2;
            resize();
        }
        return elm;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int iteratorIndex = numElms;

            @Override
            public boolean hasNext() {
                return iteratorIndex != 0;
            }

            @Override
            public T next() {
                return array[--iteratorIndex];
            }
        };
    }
}
