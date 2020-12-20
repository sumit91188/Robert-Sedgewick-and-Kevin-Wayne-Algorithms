package fundamentals.bagsQueuesStacks;

import java.util.Stack;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/20/20
 * @comment: Write an iterable Stack client that has a static method copy() that takes a stack of
 * strings as argument and returns a copy of the stack. Note : This ability is a prime example of
 * the value of having an iterator, because it allows development of such functionality without
 * changing the basic API.
 */
public class Exercise12 {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<String>();
    stack.push("a");
    stack.push("b");
    stack.push("c");
    stack.push("d");
    stack.push("e");
    stack.push("f");
    stack.push("g");

    System.out.print("Stack: ");
    for (String i : stack) {
      System.out.print(i + " ");
    }
    System.out.println();

    Stack<String> stackCopy = copyStack(stack);

    stack.pop();
    stack.pop();
    stackCopy.push("h");

    System.out.print("Stack: ");
    for (String i : stack) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.print("Stack Copy: ");
    for (String i : stackCopy) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  private static Stack<String> copyStack(Stack<String> stack) {
    Stack<String> stackTemp = new Stack<>();
    Stack<String> stackCopy = new Stack<>();

    for (String str : stack) {
      stackTemp.push(str);
    }

    for (String str : stackTemp) {
      stackCopy.push(str);
    }
    return stackCopy;
  }
}
