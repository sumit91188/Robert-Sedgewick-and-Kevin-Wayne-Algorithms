package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownStack;

/**
 * @author Sumit Deo
 * @Date 8/11/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Text editor buffer. Develop a data type for a buffer in a text editor that implements
 * the following API:
 * public class Buffer
 * Buffer() create an empty buffer
 * void insert(char c) insert c at the cursor position
 * char delete() delete and return the character at the cursor
 * void left(int k) move the cursor k positions to the left
 * void right(int k) move the cursor k positions to the right
 * int size() number of characters in the buffer
 * API for a text buffer
 * Hint : Use two stacks.
 */
public class Exercise44 {
    public static void main(String[] args) {
        Buffer<Character> buffer = new Buffer<>();
        buffer.insert('s');
        buffer.insert('u');
        buffer.insert('m');
        buffer.insert('i');
        buffer.insert('t');
        buffer.insert(' ');
        buffer.insert('d');
        buffer.insert('e');
        buffer.insert('o');

        System.out.println(buffer.toString());

        buffer.left(10);
        System.out.println(buffer.toString());

        buffer.insert('m');
        buffer.insert('r');
        buffer.insert('.');
        buffer.insert(' ');
        System.out.println(buffer.toString());

        buffer.right(6);
        buffer.insert('s');
        buffer.insert('a');
        buffer.insert('n');
        buffer.insert('j');
        buffer.insert('a');
        buffer.insert('y');
        buffer.insert(' ');

        System.out.println(buffer.toString());
    }

    private static class Buffer<T> {
        PushDownStack<T> leftStack;
        PushDownStack<T> rightStack;

        public Buffer() {
            leftStack = new PushDownStack<>();
            rightStack = new PushDownStack<>();
        }

        public void insert(T elm) {
            leftStack.push(elm);
        }

        public void delete() {
            leftStack.pop();
        }

        public void left(int k) {
            for (int i = 0; i < k && leftStack.size() > 0; i++) {
                rightStack.push(leftStack.pop());
            }
        }

        public void right(int k) {
            for (int i = 0; i < k && rightStack.size() > 0; i++) {
                leftStack.push(rightStack.pop());
            }
        }

        public int size() {
            return leftStack.size() + rightStack.size();
        }

        @Override
        public String toString() {
            PushDownStack<T> stack = new PushDownStack<>();

            for (T elm : leftStack) {
                stack.push(elm);
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (T elm : stack) {
                stringBuilder.append(elm);
            }

            for (T elm : rightStack) {
                stringBuilder.append(elm);
            }

            return stringBuilder.toString();
        }
    }
}
