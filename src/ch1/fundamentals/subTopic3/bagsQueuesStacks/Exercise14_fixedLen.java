package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Sumit Deo
 */
public class Exercise14_fixedLen {

    public static void main(String[] args) {
        Queue queue = new Queue(2);
        queue.enqueue("first");
        queue.enqueue("second");

        assertThrows(RuntimeException.class, () -> queue.enqueue("third"));

        assertEquals("first", queue.dequeue());
        assertEquals("second", queue.dequeue());

        assertThrows(RuntimeException.class, () -> queue.dequeue());
    }

    private static class Queue {
        private String[] elms;
        private int numElms;
        int first;
        int last;

        public Queue(int capacity) {
            elms = new String[capacity];
        }

        public int size() {
            return numElms;
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        public void enqueue(String elm) throws RuntimeException{
            if (numElms == elms.length) {
                throw new RuntimeException("Queue overflow");
            }

            elms[last++] = elm;
            numElms++;
        }

        public String dequeue() throws RuntimeException{
            if (isEmpty()) {
                throw new RuntimeException("Empty Queue");
            }

            String elm = elms[first++];
            numElms--;
            return elm;
        }
    }
}
