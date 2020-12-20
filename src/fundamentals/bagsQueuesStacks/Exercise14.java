package fundamentals.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/20/20
 * @comment: Develop a class ResizingArrayQueueOfStrings that implements the queue abstraction with
 * a fixed-size array, and then extend your implementation to use array resizing to remove the size
 * restriction.
 */
public class Exercise14 {

  public static void main(String[] args) {
    ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings(5);

    queue.enQueue("a");
    queue.enQueue("b");
    queue.enQueue("c");
    queue.enQueue("d");
    queue.enQueue("e");
    queue.enQueue("f");

    System.out.print("Queue: ");
    for (String str : queue) {
      System.out.print(str + " ");
    }
    System.out.println();
    System.out.println("Size: " + queue.size());
    System.out.println("Dequeue: " + queue.deQueue());
    System.out.println("Size: " + queue.size());

    System.out.print("Queue: ");
    for (String str : queue) {
      System.out.print(str + " ");
    }

    System.out.println();
    System.out.println("Size: " + queue.size());
    queue.enQueue("g");
    System.out.println("Size: " + queue.size());

    System.out.print("Queue: ");
    for (String str : queue) {
      System.out.print(str + " ");
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
      String data = array[0];

      for (int i = 1; i < numOfElms; i++) {
        array[i - 1] = array[i];
      }

      array[--numOfElms] = null;

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
