package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.CircularLinkedList;
import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownQueue;
import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownStack;
import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.Stqueue;

/**
 * @author Sumit Deo
 * @Date 8/16/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Catenable queues, stacks, or steques. Add an extra operation catenation that (destructively)
 * concatenates two queues, stacks, or steques (see Exercise 1.3.32). Hint : Use
 * a circular linked list, maintaining a pointer to the last item.
 */
public class Exercise47 {
    public static void main(String[] args) {
        PushDownQueue<Integer> queue1 = new PushDownQueue<>();
        queue1.enqueue(0);
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);

        PushDownQueue<Integer> queue2 = new PushDownQueue<>();
        queue2.enqueue(7);
        queue2.enqueue(8);
        queue2.enqueue(9);

        CircularLinkedList<Integer> linkedList = concatenation(queue1, queue2);
        StringBuilder builder = new StringBuilder();
        for (int i : linkedList) {
            builder.append(i);
        }
        System.out.println(builder.toString());

        PushDownStack<Integer> stack1 = new PushDownStack<>();
        stack1.push(0);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        PushDownStack<Integer> stack2 = new PushDownStack<>();
        stack2.push(7);
        stack2.push(8);
        stack2.push(9);

        linkedList = concatenation(stack1, stack2);
        builder = new StringBuilder();
        for (int i : linkedList) {
            builder.append(i);
        }
        System.out.println(builder.toString());

        Stqueue<Integer> stqueue1 = new Stqueue<>();
        stqueue1.push(0);
        stqueue1.push(1);
        stqueue1.push(2);
        stqueue1.push(3);

        Stqueue<Integer> stqueue2 = new Stqueue<>();
        stqueue2.push(7);
        stqueue2.push(8);
        stqueue2.push(9);

        linkedList = concatenation(stqueue1, stqueue2);
        builder = new StringBuilder();
        for (int i : linkedList) {
            builder.append(i);
        }
        System.out.println(builder.toString());
    }

    private static CircularLinkedList<Integer> concatenation(Stqueue<Integer> stqueue1, Stqueue<Integer> stqueue2) {
        if (stqueue1 == null || stqueue2 == null) {
            throw new RuntimeException("Cannot concatenate null stqueue.");
        }

        CircularLinkedList<Integer> linkedList = new CircularLinkedList<>();
        while (!stqueue1.isEmpty()) {
            linkedList.enqueue(stqueue1.pop());
        }

        while (!stqueue2.isEmpty()) {
            linkedList.enqueue(stqueue2.pop());
        }

        return linkedList;
    }

    private static CircularLinkedList<Integer> concatenation(PushDownStack<Integer> stack1, PushDownStack<Integer> stack2) {
        if (stack1 == null || stack2 == null) {
            throw new RuntimeException("Cannot concatenate null stack.");
        }

        CircularLinkedList<Integer> linkedList = new CircularLinkedList<>();
        while (!stack1.isEmpty()) {
            linkedList.enqueue(stack1.pop());
        }

        while (!stack2.isEmpty()) {
            linkedList.enqueue(stack2.pop());
        }

        return linkedList;
    }

    private static CircularLinkedList<Integer> concatenation(PushDownQueue<Integer> queue1, PushDownQueue<Integer> queue2) {

        if (queue1 == null || queue2 == null) {
            throw new RuntimeException("Cannot concatenate null queue.");
        }

        CircularLinkedList<Integer> linkedList = new CircularLinkedList<>();
        while (!queue1.isEmpty()) {
            linkedList.enqueue(queue1.dequeue());
        }

        while (!queue2.isEmpty()) {
            linkedList.enqueue(queue2.dequeue());
        }

        return linkedList;
    }
}
