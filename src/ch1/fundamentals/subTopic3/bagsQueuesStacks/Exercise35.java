package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Sumit Deo
 * @Date 8/6/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Random queue. A random queue stores a collection of items and supports the
 * following API:
 * public class RandomQueue<Item>
 * RandomQueue() create an empty random queue
 * boolean isEmpty() is the queue empty?
 * void enqueue(Item item) add an item
 * Item dequeue() remove and return a random item
 * (sample without replacement)
 * Item sample() return a random item, but do not remove
 * (sample with replacement)
 * API for a generic random queue
 * Write a class RandomQueue that implements this API. Hint : Use an array representation
 * (with resizing). To remove an item, swap one at a random position (indexed 0 through
 * N-1) with the one at the last position (index N-1). Then delete and return the last object,
 * as in ResizingArrayStack. Write a client that deals bridge hands (13 cards each)
 * using RandomQueue<Card>.
 */
public class Exercise35 {

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

    private static class RandomQueue<T> {
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

        private void sortArrayCopy() {
            T[] arrayCopy = (T[]) new Object[numElms];
            for (int i = 0; i < numElms; i++) {
                int randomIndex = StdRandom.uniform(0, numElms - 1);
                T temp = arrayCopy[i];
                arrayCopy[i] = arrayCopy[randomIndex];
                arrayCopy[randomIndex] = temp;
            }
            array = arrayCopy;
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
    }
}
