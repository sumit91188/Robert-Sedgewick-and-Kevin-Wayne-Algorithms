package fundamentals.bagsQueuesStacks;

import fundamentals.bagsQueuesStacks.util.ResizingArrayStack;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 1/7/21
 * @comment: Copy a stack. Create a new constructor for the linked-list implementation of Stack so
 * that Stack<Item> t = new Stack<Item>(s); makes t a reference to a new and independent copy of the
 * stack s.
 */
public class Exercise42 {

  public static void main(String[] args) {
    ResizingArrayStack<Integer> stack = new ResizingArrayStack<>(4);

    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
    stack.push(50);

    System.out.print("Queue: ");
    for (int i : stack) {
      System.out.print(i + " ");
    }
    System.out.println();

    Stack<Integer> copiedStack = new Stack<Integer>(stack);

    System.out.print("Copied Queue: ");
    for (int i : copiedStack) {
      System.out.print(i + " ");
    }
    System.out.println();

    stack.pop();
    stack.pop();
    copiedStack.push(60);
    copiedStack.push(70);

    System.out.print("Queue: ");
    for (int i : stack) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.print("Copied Queue: ");
    for (int i : copiedStack) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  private static class Stack<T> extends ResizingArrayStack<T> {

    public Stack(ResizingArrayStack<T> stack) {
      super(stack.size());
      ResizingArrayStack<T> tempStack = new ResizingArrayStack<>(stack.size());
      for (T i : stack) {
        tempStack.push(i);
      }
      for (T i : tempStack) {
        push(i);
      }
    }
  }
}
