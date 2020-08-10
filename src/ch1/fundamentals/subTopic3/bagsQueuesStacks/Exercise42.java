package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownStack;

import java.util.StringJoiner;

/**
 * @author Sumit Deo
 * @Date 8/9/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Copy a stack. Create a new constructor for the linked-list implementation of
 * Stack so that
 * Stack<Item> t = new Stack<Item>(s);
 * makes t a reference to a new and independent copy of the stack s.
 */
public class Exercise42 {
    public static void main(String[] args) {
        PushDownStack<Integer> stack = new PushDownStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        CopyStack<Integer> copyStack = new CopyStack<>(stack);

        stack.pop();
        stack.pop();

        StringJoiner originalQueueItems = new StringJoiner(" ");
        for (int item : stack) {
            originalQueueItems.add(String.valueOf(item));
        }
        System.out.println(originalQueueItems.toString());

        originalQueueItems = new StringJoiner(" ");
        for (int item : copyStack) {
            originalQueueItems.add(String.valueOf(item));
        }
        System.out.println(originalQueueItems.toString());
    }

    private static class CopyStack<T> extends PushDownStack<T> {
        public CopyStack(PushDownStack<T> stack) {
            PushDownStack<T> tempStack = new PushDownStack<>();
            for (T elm : stack) {
                tempStack.push(elm);
            }

            for (T elm : tempStack) {
                push(elm);
            }
        }
    }
}
