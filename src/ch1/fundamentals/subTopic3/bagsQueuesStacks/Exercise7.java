package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownStack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Sumit Deo
 */
public class Exercise7 {

    public static void main(String[] args) {
        PushDownStack<Integer> stack = new PushDownStack<Integer>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.peek());
        assertEquals(30, stack.peek());
    }
}
