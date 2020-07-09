package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownQueue;
import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownStack;

/**
 * @author Sumit Deo
 */
public class Exercise6 {

    public static void main(String[] args) {
        PushDownQueue<String> queue = new PushDownQueue<String>();
        PushDownStack<String> stack = new PushDownStack<String>();

        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");

        while (! queue.isEmpty()) {
            stack.push(queue.dequeue());
        }

        while (! stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }

        System.out.print("Queue is - ");
        for (String str : queue) {
            System.out.print(str + " ");
        }
    }
}
