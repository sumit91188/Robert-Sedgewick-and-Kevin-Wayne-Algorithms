package fundamentals.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/19/20
 * @comment: Give the contents and size of the array for DoublingStackOfStrings with the input it
 * was - the best - of times - - - it was - the - -
 */
public class Exercise8 {

  public static void main(String[] args) {
    DoublingStackOfStrings stack = new DoublingStackOfStrings(5);
    String inputString = "it was - the best - of times - - - it was - the - -";

    String[] inputs = inputString.split(" ");
    for (String input : inputs) {
      if (input.equals("-")) {
        stack.pop();
      } else {
        stack.push(input);
      }
    }

    System.out.print("Stack: ");
    for (String i : stack) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  private static class DoublingStackOfStrings implements Iterable<String> {

    private String[] array;
    private int numOfElms = 0;
    private int maxNumOfElms;

    public DoublingStackOfStrings(int maxNumOfElms) {
      this.maxNumOfElms = maxNumOfElms;
      array = new String[this.maxNumOfElms];
    }

    public boolean isEmpty() {
      return numOfElms == 0;
    }

    public int size() {
      return numOfElms;
    }

    public void push(String item) {
      if (numOfElms == maxNumOfElms) {
        resize(maxNumOfElms * 2);
      }
      array[numOfElms++] = item;
    }

    public String pop() {
      String item = array[--numOfElms];
      array[numOfElms] = null;
      if (numOfElms > 0 && numOfElms == maxNumOfElms / 4) {
        resize(maxNumOfElms / 2);
      }
      return item;
    }

    private void resize(int maxNumOfElms) {
      this.maxNumOfElms = maxNumOfElms;
      String[] tempArray = new String[this.maxNumOfElms];

      for (int i = 0; i < numOfElms; i++) {
        tempArray[i] = array[i];
      }

      array = tempArray;
    }

    @Override
    public Iterator<String> iterator() {
      return new Iterator<String>() {

        int iteratorIndex = numOfElms;

        @Override
        public boolean hasNext() {
          return iteratorIndex > 0;
        }

        @Override
        public String next() {
          return array[--iteratorIndex];
        }
      };
    }
  }
}
