package fundamentals.bagsQueuesStacks;

import fundamentals.bagsQueuesStacks.util.ResizingArrayStack;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 1/8/21
 * @comment: Text editor buffer. Develop a data type for a buffer in a text editor that implements
 * the following API:
 */
public class Exercise44 {

  public static void main(String[] args) {
    Buffer buffer = new Buffer();

    buffer.insert('s');
    buffer.insert('u');
    buffer.insert('m');
    buffer.insert('i');
    buffer.insert('t');
    buffer.insert(' ');
    buffer.insert('d');
    buffer.insert('e');
    buffer.insert('o');
    System.out.println("Buffer: " + buffer.toString());

    buffer.left(3);
    buffer.insert('s');
    buffer.insert('a');
    buffer.insert('n');
    buffer.insert('j');
    buffer.insert('a');
    buffer.insert('y');
    buffer.insert(' ');
    System.out.println("Buffer: " + buffer.toString());

    buffer.right(3);
    buffer.insert(',');
    buffer.insert(' ');
    buffer.insert('u');
    buffer.insert('s');
    System.out.println("Buffer: " + buffer.toString());

    buffer.delete();
    buffer.delete();
    buffer.delete();
    buffer.delete();
    System.out.println("Buffer: " + buffer.toString());

    buffer.left(4);
    buffer.delete();
    buffer.delete();
    buffer.delete();
    buffer.delete();
    buffer.delete();
    buffer.delete();
    buffer.delete();
    System.out.println("Buffer: " + buffer.toString());

    buffer.left(100);
    buffer.insert('M');
    buffer.insert('r');
    buffer.insert(' ');
    System.out.println("Buffer: " + buffer.toString());

    buffer.right(100);
    buffer.insert('!');
    buffer.insert('!');
    buffer.insert('!');
    System.out.println("Buffer: " + buffer.toString());
  }

  private static class Buffer {

    ResizingArrayStack<Character> leftStack;
    ResizingArrayStack<Character> rightStack;
    int numOfElms;
    int cursorIndex;

    public Buffer() {
      leftStack = new ResizingArrayStack<>(10);
      rightStack = new ResizingArrayStack<>(10);
    }

    public int size() {
      return numOfElms;
    }

    public void insert(char c) {
      leftStack.push(c);
      cursorIndex++;
      numOfElms++;
    }

    public char delete() {
      char elem = leftStack.pop();
      cursorIndex--;
      numOfElms--;
      return elem;
    }

    public void left(int k) {
      if (k > cursorIndex) {
        k = cursorIndex;
      }
      int originalCursorIndex = cursorIndex;
      for (int i = cursorIndex; i > originalCursorIndex - k; i--) {
        rightStack.push(leftStack.pop());
        cursorIndex--;
      }
    }

    public void right(int k) {
      for (int i = cursorIndex; i < numOfElms; i++) {
        leftStack.push(rightStack.pop());
        cursorIndex++;
      }
    }

    @Override
    public String toString() {
      ResizingArrayStack<Character> tempStack = new ResizingArrayStack<>(leftStack.size());
      for (char ch : leftStack) {
        tempStack.push(ch);
      }

      StringBuilder stringBuilder = new StringBuilder();

      for (char ch : tempStack) {
        stringBuilder.append(ch);
      }

      for (char ch : rightStack) {
        stringBuilder.append(ch);
      }

      return stringBuilder.toString();
    }
  }
}
