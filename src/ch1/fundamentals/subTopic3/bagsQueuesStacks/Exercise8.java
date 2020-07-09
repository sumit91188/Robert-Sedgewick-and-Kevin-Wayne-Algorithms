package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.ResizingArrayStack;
import edu.princeton.cs.algs4.StdIn;

/**
 * @author Sumit Deo
 */
public class Exercise8 {

    public static void main(String[] args) {
        ResizingArrayStack stack = new ResizingArrayStack();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();

            if (!item.equals("-")) {
                stack.push(item);
            } else if (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        }

        System.out.println(stack.size() + " elements left.");
    }
}
