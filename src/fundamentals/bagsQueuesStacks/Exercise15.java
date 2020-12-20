package fundamentals.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/20/20
 * @comment: Write a Queue client that takes a command-line argument k and prints the kth from the
 * last string found on standard input (assuming that standard input has k or more strings).
 */
public class Exercise15 {

  public static void main(String[] args) {
    ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings(5);
    int k = Integer.parseInt(args[0]); // 5

    String input = args[1]; // 1 2 3 4 5 6 7 8 9 10 11 12
    String[] stringsInput = input.split(" ");

    for (String string : stringsInput) {
      queue.enQueue(string);
    }

    int size = queue.size();
    int count = 0;
    for (String str : queue) {
      if (count++ == size - k) {
        System.out.println("Kth element from last is: " + str); // 8
        break;
      }
    }
  }

  private static class ResizingArrayQueueOfStrings implements Iterable<String> {

    private String[] array;
    private int numOfElms;
    private int maxNumOfElms;

    public ResizingArrayQueueOfStrings(int maxNumOfElms) {
      this.maxNumOfElms = maxNumOfElms;
      array = new String[this.maxNumOfElms];
    }

    public boolean isEmpty() {
      return numOfElms == 0;
    }

    public int size() {
      return numOfElms;
    }

    public void enQueue(String data) {
      if (numOfElms == maxNumOfElms) {
        increaseCapacity();
      }
      array[numOfElms++] = data;
    }

    private void increaseCapacity() {
      this.maxNumOfElms *= 2;
      String[] tempArray = new String[this.maxNumOfElms];

      for (int i = 0; i < numOfElms; i++) {
        tempArray[i] = array[i];
      }

      array = tempArray;
    }

    public String deQueue() {
      if (isEmpty()) {
        throw new RuntimeException("Queue is empty.");
      }

      String data = array[0];

      for (int i = 1; i < numOfElms; i++) {
        array[i - 1] = array[i];
      }

      array[--numOfElms] = null;

      if (maxNumOfElms / numOfElms == 2) {
        increaseCapacity();
      }

      return data;
    }

    @Override
    public Iterator<String> iterator() {
      return new Iterator<String>() {

        int iteratorIndex = 0;

        @Override
        public boolean hasNext() {
          return iteratorIndex != numOfElms;
        }

        @Override
        public String next() {
          return array[iteratorIndex++];
        }
      };
    }
  }
}
