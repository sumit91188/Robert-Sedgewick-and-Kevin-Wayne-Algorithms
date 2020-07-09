package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownStack;

/**
 * @author Sumit Deo
 */
public class Exercise5 {

    public static void main(String[] args) {
        int N = 50;
        PushDownStack<Integer> stack = new PushDownStack<>();

        while (N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }

        for (int i : stack) {
            System.out.print(i); //Prints the binary representation of N (110010 when N is 50).
        }
    }
}
