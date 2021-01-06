package fundamentals.bagsQueuesStacks;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 1/6/21
 * @comment: Random iterator. Write an iterator for RandomQueue<Item> from the previous exercise
 * that returns the items in random order.
 */
public class Exercise36 {

  public static void main(String[] args) {
    RandomQueue<Integer> queue = new RandomQueue<>();

    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.enqueue(40);
    queue.enqueue(50);
    queue.enqueue(60);
    queue.enqueue(70);
    queue.enqueue(80);
    queue.enqueue(90);

    System.out.print("Random Queue: ");
    for (int i : queue) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Remove randomly: " + queue.dequeue());
    System.out.print("Random Queue: ");
    for (int i : queue) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Remove randomly: " + queue.dequeue());
    System.out.print("Random Queue: ");
    for (int i : queue) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Sample randomly: " + queue.sample());
    System.out.print("Random Queue: ");
    for (int i : queue) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  private static class RandomQueue<T> implements Iterable<T> {

    T[] array;
    int numOfElms;
    int maxNumOfElms;

    public RandomQueue() {
      this.maxNumOfElms = 5;
      array = (T[]) new Object[this.maxNumOfElms];
    }

    public boolean isEmpty() {
      return numOfElms == 0;
    }

    public int size() {
      return numOfElms;
    }

    public void enqueue(T ele) {
      if (numOfElms == maxNumOfElms) {
        increaseCapacity();
      }

      array[numOfElms++] = ele;
    }

    private void increaseCapacity() {
      maxNumOfElms *= 2;
      array = Arrays.copyOf(array, maxNumOfElms);
    }

    public T dequeue() {
      int random = StdRandom.uniform(numOfElms);
      T ele = array[random];
      array[random] = array[--numOfElms];
      return ele;
    }

    public T sample() {
      int random = StdRandom.uniform(numOfElms);
      return array[random];
    }

    @Override
    public Iterator<T> iterator() {
      return new RandomQueueIterator();
    }

    private class RandomQueueIterator implements Iterator<T> {

      T[] iteratorArray;
      int iteratorIndex;

      public RandomQueueIterator() {
        iteratorIndex = numOfElms;
        iteratorArray = (T[]) new Object[numOfElms];

        for (int i = 0; i < numOfElms; i++) {
          iteratorArray[i] = array[i];
        }
      }

      @Override
      public boolean hasNext() {
        return iteratorIndex > 0;
      }

      @Override
      public T next() {
        T elem = null;
        if (hasNext()) {
          int random = StdRandom.uniform(iteratorIndex);
          elem = iteratorArray[random];
          iteratorArray[random] = iteratorArray[iteratorIndex - 1];
          iteratorArray[iteratorIndex - 1] = null;
          iteratorIndex--;
        }
        return elem;
      }
    }
  }
}
