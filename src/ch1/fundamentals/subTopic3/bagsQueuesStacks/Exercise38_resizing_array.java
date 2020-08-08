package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author Sumit Deo
 * @Date 8/8/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Delete kth element. Implement a class that supports the following API:
 * public class GeneralizedQueue<Item>
 * GeneralizedQueue() create an empty queue
 * boolean isEmpty() is the queue empty?
 * void insert(Item x) add an item
 * Item delete(int k) delete and return the kth least recently inserted item
 * API for a generic generalized queue
 * First, develop an implementation that uses an array implementation, and then develop
 * one that uses a linked-list implementation. Note : the algorithms and data structures
 * that we introduce in Chapter 3 make it possible to develop an implementation that
 * can guarantee that both insert() and delete() take time prortional to the logarithm
 * of the number of items in the queue—see Exercise 3.5.27.
 */
public class Exercise38_resizing_array {
    public static void main(String[] args) {
        ResizingArrayQueue arrayQueue = new ResizingArrayQueue();
        arrayQueue.insert(10);
        arrayQueue.insert(20);
        arrayQueue.insert(30);
        arrayQueue.insert(40);
        arrayQueue.insert(50);
        arrayQueue.insert(60);

        System.out.println(arrayQueue.toString());

        arrayQueue.delete(2);
        System.out.println(arrayQueue.toString());

        arrayQueue.delete(3);
        System.out.println(arrayQueue.toString());
    }

    private static class ResizingArrayQueue<T> implements Iterable<T> {

        int maxNumElms = 1;
        int numElms;
        T[] array;

        public ResizingArrayQueue() {
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

        public void insert(T elm) {
            if (numElms == maxNumElms) {
                maxNumElms *= 2;
                resize();
            }
            array[numElms++] = elm;
        }

        public T delete(int k) {
            if (isEmpty()) {
                throw new RuntimeException("Empty ResizingArrayQueue");
            }

            if (k <= 0 || k > numElms) {
                throw new RuntimeException("Invalid value of k, should be grater than 0 and less than number of elements");
            }

            T elm = array[k - 1];

            for (int i = k; i < numElms; i++) {
                array[i - 1] = array[i];
            }

            array[--numElms] = null;

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

        @Override
        public String toString() {

            StringBuilder dequeItems = new StringBuilder("[");

            int index = 0;
            while (true) {
                if (index == numElms) {
                    dequeItems.append("]");
                    break;
                } else if (index == 0) {
                    dequeItems.append(array[index++]);
                } else {
                    dequeItems.append(", ");
                    dequeItems.append(array[index++]);
                }
            }

            return dequeItems.toString();
        }
    }
}
