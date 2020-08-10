package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownQueue;

import java.util.StringJoiner;

/**
 * @author Sumit Deo
 * @Date 8/9/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Copy a queue. Create a new constructor so that
 * Queue<Item> r = new Queue<Item>(q);
 * makes r a reference to a new and independent copy of the queue q. You should be able
 * to push and pop from either q or r without influencing the other. Hint : Delete all of the
 * elements from q and add these elements to both q and r.
 */
public class Exercise41 {
    public static void main(String[] args) {
        PushDownQueue<Integer> queue = new PushDownQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);

        CopyQueue<Integer> copyQueue = new CopyQueue<>(queue);

        queue.dequeue();
        queue.dequeue();
        StringJoiner originalQueueItems = new StringJoiner(" ");
        for (int item : queue) {
            originalQueueItems.add(String.valueOf(item));
        }
        System.out.println(originalQueueItems.toString());

        originalQueueItems = new StringJoiner(" ");
        for (int item : copyQueue) {
            originalQueueItems.add(String.valueOf(item));
        }
        System.out.println(originalQueueItems.toString());
    }

    private static class CopyQueue<T> extends PushDownQueue<T> {
        public CopyQueue(PushDownQueue<T> queue) {
            for (T elm : queue) {
                enqueue(elm);
            }
        }
    }
}
