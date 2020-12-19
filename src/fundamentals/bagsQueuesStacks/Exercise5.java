package fundamentals.bagsQueuesStacks;

import edu.princeton.cs.algs4.StdOut;
import java.util.Stack;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/19/20
 * @comment: What does the following code fragment print when N is 50? Give a high-level description
 * of what it does when presented with a positive integer N.
 */
public class Exercise5 {

  public static void main(String[] args) {
    int N = 50;
    Stack<Integer> stack = new Stack<Integer>();
    while (N > 0) {
      stack.push(N % 2);
      N = N / 2;
    }
    for (int d : stack) {
      StdOut.print(d);
    }
    StdOut.println();
  }
}

//Prints the binary representation of N (110010 when N is 50).