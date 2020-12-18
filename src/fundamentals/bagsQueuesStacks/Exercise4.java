package fundamentals.bagsQueuesStacks;

import fundamentals.bagsQueuesStacks.util.ResizingArrayStack;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/18/20
 * @comment: Write a stack client Parentheses that reads in a text stream from standard input and
 * uses a stack to determine whether its parentheses are properly balanced. For example, your
 * program should print true for [()]{}{[()()]()} and false for [(]).
 */
public class Exercise4 {

  public static void main(String[] args) {
    String parentheses = "[()]{}{[()()]()}";
    System.out.println(
        "Parentheses \"" + parentheses + "\" is balanced: " + isBalanced(parentheses));

    parentheses = "[(])";
    System.out.println(
        "Parentheses \"" + parentheses + "\" is balanced: " + isBalanced(parentheses));
  }

  private static boolean isBalanced(String parentheses) {
    ResizingArrayStack<Character> leftFacingParentheses = new ResizingArrayStack<>(10);
    ResizingArrayStack<Character> stack = new ResizingArrayStack<>(10);

    for (char parenthesis : parentheses.toCharArray()) {
      if ("{[(".indexOf(parenthesis) != -1) {
        stack.push(parenthesis);
        continue;
      }

      if (stack.isEmpty()) {
        return false;
      }

      char rightFacingParenthesis = stack.pop();
      if (rightFacingParenthesis == '{' && parenthesis != '}') {
        return false;
      } else if (rightFacingParenthesis == '[' && parenthesis != ']') {
        return false;
      } else if (rightFacingParenthesis == '(' && parenthesis != ')') {
        return false;
      }
    }
    return true;
  }
}
