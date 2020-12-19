package fundamentals.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/19/20
 * @comment: Add a method peek() to Stack that returns the most recently inserted item on the stack
 * (without popping it).
 */
public class Exercise7 {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<String>(10);
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

    System.out.println("Peek an element: " + stack.peek());

    System.out.print("Stack: ");
    for (String i : stack) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  private static class Stack<Item> implements Iterable<Item> {

    private Item[] array;
    private int numOfElms = 0;
    private int maxNumOfElms;

    public Stack(int maxNumOfElms) {
      this.maxNumOfElms = maxNumOfElms;
      array = (Item[]) new Object[this.maxNumOfElms];
    }

    public boolean isEmpty() {
      return numOfElms == 0;
    }

    public int size() {
      return numOfElms;
    }

    public void push(Item item) {
      if (numOfElms == maxNumOfElms) {
        resize(maxNumOfElms * 2);
      }
      array[numOfElms++] = item;
    }

    public Item pop() {
      Item item = array[--numOfElms];
      array[numOfElms] = null;
      if (numOfElms > 0 && numOfElms == maxNumOfElms / 4) {
        resize(maxNumOfElms / 2);
      }
      return item;
    }

    public Item peek() {
      return array[numOfElms - 1];
    }

    private void resize(int maxNumOfElms) {
      this.maxNumOfElms = maxNumOfElms;
      Item[] tempArray = (Item[]) new Object[this.maxNumOfElms];

      for (int i = 0; i < numOfElms; i++) {
        tempArray[i] = array[i];
      }

      array = tempArray;
    }

    @Override
    public Iterator<Item> iterator() {
      return new Iterator<Item>() {

        int iteratorIndex = numOfElms;

        @Override
        public boolean hasNext() {
          return iteratorIndex > 0;
        }

        @Override
        public Item next() {
          return array[--iteratorIndex];
        }
      };
    }
  }
}
