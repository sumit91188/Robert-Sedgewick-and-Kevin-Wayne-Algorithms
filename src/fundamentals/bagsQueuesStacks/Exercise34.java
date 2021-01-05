package fundamentals.bagsQueuesStacks;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 1/5/21
 * @comment: Random bag. A random bag stores a collection of items and supports the following API:
 * Write a class RandomBag that implements this API. Note that this API is the same as for Bag,
 * except for the adjective random, which indicates that the iteration should provide the items in
 * random order (all N ! permutations equally likely, for each iterator). Hint : Put the items in an
 * array and randomize their order in the iterator’s constructor.
 */
public class Exercise34 {

  public static void main(String[] args) {
    RandomBag<Integer> bag = new RandomBag<>();

    bag.add(10);
    bag.add(20);
    bag.add(30);
    bag.add(40);
    bag.add(50);
    bag.add(60);
    bag.add(70);
    bag.add(80);

    System.out.print("Random Bag: ");
    for (int i : bag) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.print("Random Bag: ");
    for (int i : bag) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.print("Random Bag: ");
    for (int i : bag) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  private static class RandomBag<T> implements Iterable<T> {

    T[] array;
    int numOfElms;
    int maxNumOfElms;

    public RandomBag() {
      this.maxNumOfElms = 5;
      array = (T[]) new Object[this.maxNumOfElms];
    }

    public boolean isEmpty() {
      return numOfElms == 0;
    }

    public int size() {
      return numOfElms;
    }

    public void add(T elem) {
      if (numOfElms == maxNumOfElms) {
        increaseCapacity();
      }
      array[numOfElms++] = elem;
    }

    private void increaseCapacity() {
      maxNumOfElms *= 2;
      array = Arrays.copyOf(array, maxNumOfElms);
    }

    @Override
    public Iterator<T> iterator() {
      return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<T> {

      T[] iteratorArray;
      int iteratorIndex;

      public RandomBagIterator() {
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
