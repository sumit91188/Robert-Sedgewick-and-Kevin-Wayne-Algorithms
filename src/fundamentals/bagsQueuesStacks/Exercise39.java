package fundamentals.bagsQueuesStacks;

import fundamentals.bagsQueuesStacks.util.ArrayQueue;
import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 1/6/21
 * @comment: Ring buffer. A ring buffer, or circular queue, is a FIFO data structure of a fixed size
 * N. It is useful for transferring data between asynchronous processes or for storing log files.
 * When the buffer is empty, the consumer waits until data is deposited; when the buffer is full,
 * the producer waits to deposit data. Develop an API for a RingBuffer and an implementation that
 * uses an array representation (with circular wrap-around).
 */
public class Exercise39 {

  public static void main(String[] args) {
    RingBuffer<Integer> buffer = new RingBuffer<>(4);

    buffer.produce(10);
    buffer.produce(20);
    buffer.produce(30);

    System.out.print("Buffer: ");
    for (int i : buffer) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Consume: " + buffer.consume());
    System.out.print("Buffer: ");
    for (int i : buffer) {
      System.out.print(i + " ");
    }
    System.out.println();

    buffer.produce(40);
    buffer.produce(50);
    buffer.produce(60);
    System.out.print("Buffer: ");
    for (int i : buffer) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Consume: " + buffer.consume());
    System.out.print("Buffer: ");
    for (int i : buffer) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  private static class RingBuffer<T> implements Iterable<T> {

    T[] array;
    int numOfElms;
    int maxNumOfElms;
    ArrayQueue<T> queue;

    public RingBuffer(int maxNumOfElms) {
      this.maxNumOfElms = maxNumOfElms;
      array = (T[]) new Object[this.maxNumOfElms];
      queue = new ArrayQueue<>();
    }

    public boolean isEmpty() {
      return numOfElms == 0;
    }

    public void produce(T elem) {
      if (numOfElms == maxNumOfElms) {
        queue.offer(elem);
        return;
      }

      array[numOfElms++] = elem;
    }

    public T consume() {
      T elem = array[0];

      for (int i = 1; i < numOfElms; i++) {
        array[i - 1] = array[i];
      }

      array[--numOfElms] = null;

      if (!queue.isEmpty()) {
        produce(queue.poll());
      }

      return elem;
    }

    @Override
    public Iterator<T> iterator() {
      return new Iterator<T>() {

        int iteratorIndex;

        @Override
        public boolean hasNext() {
          return iteratorIndex < numOfElms;
        }

        @Override
        public T next() {
          T elem = null;
          if (hasNext()) {
            elem = array[iteratorIndex++];
          }
          return elem;
        }
      };
    }
  }
}
