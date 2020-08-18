package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.Deque;
import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownStack;

import java.util.Iterator;

/**
 * @author Sumit Deo
 * @Date 8/17/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Two stacks with a deque. Implement two stacks with a single deque so that each
 * operation takes a constant number of deque operations (see Exercise 1.3.33).
 */
public class Exercise48 {
    public static void main(String[] args) {
        TwoStackDeque<Integer> deque = new TwoStackDeque<Integer>();
        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushLeft(3);
        deque.pushRight(4);
        deque.pushRight(5);

        StringBuilder builder = new StringBuilder();
        for (Integer i : deque) {
            builder.append(i);
        }

        System.out.println(builder.toString());
    }

    private static class TwoStackDeque<T> implements Iterable<T> {
        Deque<T> deque;
        PushDownStack<T> stackLeft;
        PushDownStack<T> stackRight;

        public TwoStackDeque() {
            deque = new Deque<>();
            stackLeft = new PushDownStack<>();
            stackRight = new PushDownStack<>();
        }

        public void pushLeft(T elm) {
            deque.pushLeft(elm);
            stackLeft.push(elm);
        }

        public void pushRight(T elm) {
            deque.pushRight(elm);
            stackRight.push(elm);
        }

        public T popLeft() {
            if (stackLeft.isEmpty()) {
                throw new RuntimeException("Left stack underflow");
            }
            stackLeft.pop();
            return deque.popLeft();
        }

        public T popRight() {
            if (stackRight.isEmpty()) {
                throw new RuntimeException("Right stack underflow");
            }
            stackRight.pop();
            return deque.popRight();
        }

        public int size() {
            return deque.size();
        }

        @Override
        public Iterator<T> iterator() {
            return new TwoStackDequeIterator();
        }

        private class TwoStackDequeIterator implements Iterator<T> {

            T[] array;
            int index;
            int currentIndex;

            public TwoStackDequeIterator() {
                array = (T[]) new Object[deque.size()];
                index = currentIndex = deque.size() - 1;
                for (T elm : deque) {
                    array[index--] = elm;
                }
            }

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public T next() {
                T elm = null;
                if (hasNext()) {
                    elm = array[currentIndex--];
                }
                return elm;
            }
        }
    }
}
