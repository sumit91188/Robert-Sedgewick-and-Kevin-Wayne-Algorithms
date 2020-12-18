package fundamentals.bagsQueuesStacks.util;

import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/15/20
 * @comment:
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

  private Item[] array;
  private int numOfElms = 0;
  private int maxNumOfElms;

  public ResizingArrayStack(int maxNumOfElms) {
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
