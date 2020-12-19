package fundamentals.bagsQueuesStacks;

import java.util.Stack;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/19/20
 * @comment: Write a program that takes from standard input an expression without left parentheses
 * and prints the equivalent infix expression with the parentheses inserted. For example, given the
 * input: 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) ) your program should print ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5
 * - 6 ) ) )
 */
public class Exercise9 {

  public static void main(String[] args) {
    String expWithoutParentheses = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";

    System.out
        .println("Expression with the parentheses: " + expWithParentheses(expWithoutParentheses));
  }

  private static String expWithParentheses(String expWithoutParentheses) {
    Stack<String> operands = new Stack<>();
    Stack<String> operators = new Stack<>();

    String[] chars = expWithoutParentheses.split(" ");

    for (String ch : chars) {
      if (ch.equals("(")) {
        continue;
      } else if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
        operators.push(ch);
      } else if (ch.equals(")")) {
        String operandRight = operands.pop();
        String operandLeft = operands.pop();
        String expWithParentheses = "(" + operandLeft + operators.pop() + operandRight + ")";
        operands.push(expWithParentheses);
      } else {
        operands.push(ch);
      }
    }

    return operands.pop();
  }
}
