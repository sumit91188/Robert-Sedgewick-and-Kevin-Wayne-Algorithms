package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Sumit Deo
 */
public class Exercise1 {

    public static void main(String[] args) {
        FixedCapacityStack<Integer> fixedCapacityStack = new FixedCapacityStack<Integer>(2);

        fixedCapacityStack.push(10);
        assertFalse(fixedCapacityStack.isFull());

        fixedCapacityStack.push(20);
        assertTrue(fixedCapacityStack.isFull());
    }

    public static class FixedCapacityStack<Item> {

        private Item[] a;
        private int numElms;

        public FixedCapacityStack(int cap) {
            a = (Item[]) new Object[cap];
        }

        public boolean isEmpty() {
            return numElms == 0;
        }

        public int size() {
            return numElms;
        }

        public void push(Item item) {
            a[numElms++] = item;
        }

        public Item pop() {
            return a[--numElms];
        }

        public boolean isFull() {
            return numElms == a.length;
        }
    }
}
