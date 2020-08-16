package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Sumit Deo
 * @Date 8/16/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Stack generability. Suppose that we have a sequence of intermixed push and
 * pop operations as with our test stack client, where the integers 0, 1, ..., N-1 in that
 * order (push directives) are intermixed with N minus signs (pop directives). Devise an
 * algorithm that determines whether the intermixed sequence causes the stack to underflow.
 * (You may use only an amount of space independent of N—you cannot store the
 * integers in a data structure.) Devise a linear-time algorithm that determines whether a
 * given permutation can be generated as output by our test client (depending on where
 * the pop directives occur).
 * <p>
 * Solution: The stack does not overfl ow unless there exists an integer k such that the first
 * k pop operations occur before the first k push operations. If a given permutation can be
 * generated, it is uniquely generated as follows: if the next integer in the output permutation
 * is in the top of the stack, pop it; otherwise, push it onto the stack.
 */
public class Exercise45 {
    public static void main(String[] args) {
        char[] sequence = new char[]{'1', '2', '3', '-', '-', '4'};
        assertFalse(stackToUnderflow(sequence));

        sequence = new char[]{'1', '2', '3', '-', '-', '-', '4', '-', '-'};
        assertTrue(stackToUnderflow(sequence));

        sequence = new char[]{'-', '2', '3', '-', '-', '4'};
        assertTrue(stackToUnderflow(sequence));
    }

    private static boolean stackToUnderflow(char[] sequence) {
        int numElms = 0;

        for (char ch : sequence) {
            if (ch == '-') {
                numElms--;
            } else {
                numElms++;
            }

            if (numElms < 0) {
                return true;
            }
        }
        return false;
    }
}
