package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * @author Sumit Deo
 * @Date 8/6/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Random iterator. Write an iterator for RandomQueue<Item> from the previous
 * exercise that returns the items in random order.
 */
public class Exercise36 {

    public static void main(String[] args) {
        RandomQueue<Integer> randomQueue = new RandomQueue();
        randomQueue.enQueue(10);
        randomQueue.enQueue(20);
        randomQueue.enQueue(30);
        randomQueue.enQueue(40);

        System.out.println(randomQueue.sample());
        System.out.println(randomQueue.deQueue());
        System.out.println(randomQueue.deQueue());
    }

    private static class RandomQueue<T> implements Iterable<T> {
        int maxNumElms = 1;
        int numElms;
        T[] array;

        public RandomQueue() {
            numElms = 0;
            array = (T[]) new Object[maxNumElms];
        }

        public int size() {
            return numElms;
        }

        public boolean isEmpty() {
            return numElms == 0;
        }

        private void resize() {
            T[] temp = (T[]) new Object[maxNumElms];
            for (int i = 0; i < numElms; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }

        public void enQueue(T elm) {
            if (numElms == maxNumElms) {
                maxNumElms *= 2;
                resize();
            }
            array[numElms++] = elm;
        }

        public T deQueue() {
            int randomIndex = StdRandom.uniform(0, numElms - 1);
            T elm = array[randomIndex];
            array[randomIndex] = array[numElms - 1];
            array[--numElms] = null;
            return elm;
        }

        public T sample() {
            int randomIndex = StdRandom.uniform(0, numElms - 1);
            T elm = array[randomIndex];
            return elm;
        }

        @Override
        public Iterator<T> iterator() {
            return new RandomQueueIterator();
        }

        private class RandomQueueIterator implements Iterator<T> {

            T[] arrayCopy;
            int iteratorIndex;

            public RandomQueueIterator() {
                iteratorIndex = numElms;
                arrayCopy = (T[]) new Object[numElms];
                sortArrayCopy();
            }

            private void sortArrayCopy() {
                for (int i = 0; i < numElms; i++) {
                    int randomIndex = StdRandom.uniform(0, numElms - 1);
                    T temp = arrayCopy[i];
                    arrayCopy[i] = arrayCopy[randomIndex];
                    arrayCopy[randomIndex] = temp;
                }
            }

            @Override
            public boolean hasNext() {
                return iteratorIndex != 0;
            }

            @Override
            public T next() {
                return (T) arrayCopy[--iteratorIndex];
            }
        }
    }
}
