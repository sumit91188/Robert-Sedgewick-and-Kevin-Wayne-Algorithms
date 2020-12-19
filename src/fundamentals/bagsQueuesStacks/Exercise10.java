package fundamentals.bagsQueuesStacks;

import java.util.Stack;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/19/20
 * @comment: Write a filter InfixToPostfix that converts an arithmetic expression from infix to
 * postfix. ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 */
public class Exercise10 {

  public static void main(String[] args) {
    String infixExp = "( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )";

    System.out.println("Postfix expression : " + infixToPostFix(infixExp));
  }

  private static String infixToPostFix(String infixExp) {
    Stack<String> operands = new Stack<>();
    Stack<String> operators = new Stack<>();

    String[] chars = infixExp.split(" ");

    for (String ch : chars) {
      if (ch.equals("(")) {
      } else if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
        operators.push(ch);
      } else if (ch.equals(")")) {
        String operandRight = operands.pop();
        String operandLeft = operands.pop();
        String postFixExp = operandLeft + " " + operandRight + " " + operators.pop();
        operands.push(postFixExp);
      } else {
        operands.push(ch);
      }
    }

    return operands.pop();
  }
}
