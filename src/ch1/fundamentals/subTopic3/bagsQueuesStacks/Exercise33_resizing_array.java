package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Sumit Deo
 * @Date 8/6/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Deque. A double-ended queue or deque (pronounced “deck”) is like a stack or
 * a queue but supports adding and removing items at both ends. A deque stores a collection
 * of items and supports the following API:
 * public class Deque<Item> implements Iterable<Item>
 * Deque() create an empty deque
 * boolean isEmpty() is the deque empty?
 * int size() number of items in the deque
 * void pushLeft(Item item) add an item to the left end
 * void pushRight(Item item) add an item to the right end
 * Item popLeft() remove an item from the left end
 * Item popRight() remove an item from the right end
 * API for a generic double-ended queue
 * Write a class ResizingArrayDeque that uses a resizing array.
 */
public class Exercise33_resizing_array {

    public static void main(String[] args) {
        ResizingArrayQueue<Integer> deque = new ResizingArrayQueue<>();

        deque.pushLeft(10);
        deque.pushLeft(20);
        assertEquals("[20, 10]", deque.toString());

        deque.popLeft();
        assertEquals("[10]", deque.toString());

        deque.pushRight(30);
        deque.pushRight(40);
        assertEquals("[10, 30, 40]", deque.toString());

        deque.popRight();
        assertEquals("[10, 30]", deque.toString());
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

        public void pushLeft(T elm) {
            if (numElms == maxNumElms) {
                maxNumElms *= 2;
                resize();
            }

            for (int i = numElms; i > 0; i--) {
                array[i] = array[i - 1];
            }

            array[0] = elm;
            numElms++;
        }

        public void pushRight(T elm) {
            if (numElms == maxNumElms) {
                maxNumElms *= 2;
                resize();
            }
            array[numElms++] = elm;
        }

        public T popLeft() {
            if (isEmpty()) {
                throw new RuntimeException("Empty ResizingArrayQueue");
            }

            T elm = array[0];
            for (int i = 0; i < numElms - 1; i++) {
                array[i] = array[i + 1];
            }
            array[--numElms] = null;
            if (numElms > 0 && numElms == maxNumElms / 4) {
                maxNumElms /= 2;
                resize();
            }

            return elm;
        }

        public T popRight() {
            if (isEmpty()) {
                throw new RuntimeException("Empty ResizingArrayQueue");
            }

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
