package fundamentals.bagsQueuesStacks;

import java.util.Stack;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/19/20
 * @comment: Write a program EvaluatePostfix that takes a postfix expression from standard input,
 * evaluates it, and prints the value. (Piping the output of your program from the previous exercise
 * to this program gives equivalent behavior to Evaluate.
 */
public class Exercise11 {

  public static void main(String[] args) {
    String postFixExp = "1 2 + 3 4 - 5 6 - * *";

    System.out.println("Postfix expression : " + evaluateExp(postFixExp));
  }

  private static int evaluateExp(String postFixExp) {
    Stack<Integer> operands = new Stack<>();
    String[] chars = postFixExp.split(" ");

    for (String ch : chars) {
      if (ch.equals("+")) {
        int operandRight = operands.pop();
        int operandLeft = operands.pop();
        operands.push(operandLeft + operandRight);
      } else if (ch.equals("-")) {
        int operandRight = operands.pop();
        int operandLeft = operands.pop();
        operands.push(operandLeft - operandRight);
      } else if (ch.equals("*")) {
        int operandRight = operands.pop();
        int operandLeft = operands.pop();
        operands.push(operandLeft * operandRight);
      } else if (ch.equals("/")) {
        int operandRight = operands.pop();
        int operandLeft = operands.pop();
        operands.push(operandLeft / operandRight);
      } else {
        operands.push(Integer.valueOf(ch));
      }
    }

    return operands.pop();
  }
}
