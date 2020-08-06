package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.StringJoiner;

/**
 * @author Sumit Deo
 * @Date 8/6/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Random bag. A random bag stores a collection of items and supports the following
 * API:
 * public class RandomBag<Item> implements Iterable<Item>
 * RandomBag() create an empty random bag
 * boolean isEmpty() is the bag empty?
 * int size() number of items in the bag
 * void add(Item item) add an item
 * API for a generic random bag
 * Write a class RandomBag that implements this API. Note that this API is the same as for
 * Bag, except for the adjective random, which indicates that the iteration should provide
 * the items in random order (all N ! permutations equally likely, for each iterator). Hint :
 * Put the items in an array and randomize their order in the iterator’s constructor.
 */
public class Exercise34 {
    public static void main(String[] args) {
        RandomBag<Integer> randomBag = new RandomBag<>();
        randomBag.add(10);
        randomBag.add(20);
        randomBag.add(30);

        StringJoiner randomBagItems = new StringJoiner(" ");
        for (int item : randomBag) {
            randomBagItems.add(String.valueOf(item));
        }

        System.out.println(randomBagItems.toString());
    }

    private static class RandomBag<T> implements Iterable<T> {

        int maxNumElms = 1;
        int numElms;
        T[] array;

        public RandomBag() {
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

        public void add(T elm) {
            if (numElms == maxNumElms) {
                maxNumElms *= 2;
                resize();
            }
            array[numElms++] = elm;
        }

        @Override
        public Iterator<T> iterator() {
            return new RandomBagIterator();
        }

        private class RandomBagIterator<T> implements Iterator<T> {

            int iteratorIndex;
            T[] arrayCopy;

            public RandomBagIterator() {
                iteratorIndex = numElms;
                arrayCopy = (T[]) new Object[numElms];

                for (int i = 0; i < numElms; i++) {
                    arrayCopy[i] = (T) array[i];
                }

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
