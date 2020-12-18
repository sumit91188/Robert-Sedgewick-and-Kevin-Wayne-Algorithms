package fundamentals.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/18/20
 * @comment: Add a method isFull() to FixedCapacityStackOfStrings.
 */
public class Exercise1 {

  public static void main(String[] args) {
    FixedCapacityStackOfStrings stackOfStrings = new FixedCapacityStackOfStrings(5);
    stackOfStrings.push("a");
    stackOfStrings.push("b");
    stackOfStrings.push("c");

    System.out.println("Stack must not be full, isFull = " + stackOfStrings.isFull());

    stackOfStrings.push("d");
    stackOfStrings.push("e");

    System.out.println("Stack must be full, isFull = " + stackOfStrings.isFull());

    System.out.println("Last inserted index in stack is - " + stackOfStrings.pop());

    System.out.println("Stack must not be full, isFull = " + stackOfStrings.isFull());
  }

  private static class FixedCapacityStackOfStrings implements Iterable<String> {

    private final int maxNumOfElms;
    private final String[] array;
    private int numOfElms;

    public FixedCapacityStackOfStrings(int maxNumOfElms) {
      this.maxNumOfElms = maxNumOfElms;
      array = new String[this.maxNumOfElms];
    }

    public boolean isEmpty() {
      return numOfElms == 0;
    }

    public boolean isFull() {
      return numOfElms == maxNumOfElms;
    }

    public int size() {
      return numOfElms;
    }

    public void push(String data) {
      if (isFull()) {
        throw new ArrayIndexOutOfBoundsException("Stack is full");
      }
      array[numOfElms++] = data;
    }

    public String pop() {
      if (isEmpty()) {
        return null;
      }
      return array[--numOfElms];
    }

    @Override
    public Iterator<String> iterator() {
      return new Iterator<String>() {

        private int iteratorIndex = numOfElms;

        @Override
        public boolean hasNext() {
          return iteratorIndex < 0;
        }

        @Override
        public String next() {
          return array[--iteratorIndex];
        }
      };
    }
  }
}
