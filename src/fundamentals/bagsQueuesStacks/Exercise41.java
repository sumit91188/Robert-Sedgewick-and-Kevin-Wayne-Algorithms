package fundamentals.bagsQueuesStacks;

import fundamentals.bagsQueuesStacks.util.ArrayQueue;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 1/7/21
 * @comment: Copy a queue. Create a new constructor so that Queue<Item> r = new Queue<Item>(q);
 * makes r a reference to a new and independent copy of the queue q. You should be able to push and
 * pop from either q or r without influencing the other. Hint : Delete all of the elements from q
 * and add these elements to both q and r.
 */
public class Exercise41 {

  public static void main(String[] args) {
    ArrayQueue<Integer> queue = new ArrayQueue<>();

    queue.offer(10);
    queue.offer(20);
    queue.offer(30);
    queue.offer(40);
    queue.offer(50);

    System.out.print("Queue: ");
    for (int i : queue) {
      System.out.print(i + " ");
    }
    System.out.println();

    Queue<Integer> copiedQueue = new Queue(queue);

    System.out.print("Copied Queue: ");
    for (int i : copiedQueue) {
      System.out.print(i + " ");
    }
    System.out.println();

    queue.poll();
    queue.poll();
    copiedQueue.offer(60);
    copiedQueue.offer(70);

    System.out.print("Queue: ");
    for (int i : queue) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.print("Copied Queue: ");
    for (int i : copiedQueue) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  private static class Queue<T> extends ArrayQueue<T> {

    public Queue(ArrayQueue<T> queue) {
      for (T elm : queue) {
        offer(elm);
      }
    }
  }
}
