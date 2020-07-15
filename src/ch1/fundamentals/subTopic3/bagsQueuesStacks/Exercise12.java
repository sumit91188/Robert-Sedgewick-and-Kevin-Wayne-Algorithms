package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownStack;

/**
 * @author Sumit Deo
 */
public class Exercise12 {

    public static void main(String[] args) {
        PushDownStack<String> stack = new PushDownStack<>();
        stack.push("sumit");
        stack.push("sneha");
        stack.push("piku");

        PushDownStack<String> stackCopy = copy(stack);

        for (String str : stackCopy) {
            System.out.println(str);
        }
    }

    private static PushDownStack<String> copy(PushDownStack<String> stack) {
        PushDownStack<String> stackCopy = new PushDownStack<>();
        PushDownStack<String> tempStack = new PushDownStack<>();

        for (String str : stack) {
            tempStack.push(str);
        }

        for (String str : tempStack) {
            stackCopy.push(str);
        }
        return stackCopy;
    }
}
