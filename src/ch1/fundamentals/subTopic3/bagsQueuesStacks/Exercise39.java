package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownQueue;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Sumit Deo
 * @Date 8/9/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Ring buffer. A ring buffer, or circular queue, is a FIFO data structure of a fixed
 * size N. It is useful for transferring data between asynchronous processes or for storing
 * log files. When the buffer is empty, the consumer waits until data is deposited; when the
 * buffer is full, the producer waits to deposit data. Develop an API for a RingBuffer and
 * an implementation that uses an array representation (with circular wrap-around).
 */
public class Exercise39 {
    public static void main(String[] args) {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(4);
        ringBuffer.produce(10);
        ringBuffer.produce(20);
        ringBuffer.produce(30);
        ringBuffer.produce(40);
        ringBuffer.produce(50);
        ringBuffer.produce(60);
        System.out.println(ringBuffer.toString());

        ringBuffer.consume();
        ringBuffer.consume();
        System.out.println(ringBuffer.toString());

        ringBuffer.produce(70);
        ringBuffer.produce(80);
        ringBuffer.produce(90);
        ringBuffer.produce(100);
        System.out.println(ringBuffer.toString());

        ringBuffer.consume();
        ringBuffer.consume();
        System.out.println(ringBuffer.toString());
    }

    private static class RingBuffer<T> implements Iterable<T> {

        int numElms;
        int maxNumElms;
        T[] array;
        int firstIndex;
        int lastIndex;
        PushDownQueue<T> queue;

        public RingBuffer(int maxNumElms) {
            this.maxNumElms = maxNumElms;
            array = (T[]) new Object[maxNumElms];
            queue = new PushDownQueue<>();
            numElms = 0;
            firstIndex = lastIndex = -1;
        }

        private boolean isEmpty() {
            return (numElms == 0);
        }

        private boolean isFull() {
            return (numElms == maxNumElms);
        }

        public void produce(T elm) {
            if (isFull()) {
                queue.enqueue(elm);
            } else {
                lastIndex = (lastIndex + 1) % maxNumElms;
                array[lastIndex] = elm;

                if (isEmpty()) {
                    firstIndex = lastIndex;
                }

                numElms++;
            }
        }

        public T consume() {
            T elm;
            if (isEmpty()) {
                throw new RuntimeException("Ring buffer is enpty.");
            } else {
                elm = array[firstIndex];
                array[firstIndex] = null;
                firstIndex = (firstIndex + 1) % maxNumElms;
                numElms--;
                if (!queue.isEmpty()) {
                    produce(queue.dequeue());
                }
            }
            return elm;
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                int currentIdex = 0;

                @Override
                public boolean hasNext() {
                    return currentIdex == maxNumElms;
                }

                @Override
                public T next() {
                    if (hasNext()) {
                        T elm = array[currentIdex];
                        currentIdex++;
                        return elm;
                    } else {
                        throw new RuntimeException("All elements are consumed");
                    }
                }
            };
        }

        @Override
        public String toString() {
            return Arrays.toString(array);
        }
    }
}
