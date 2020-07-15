package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownStack;

/**
 * @author Sumit Deo
 */
public class Exercise11 {

    public static void main(String[] args) {
        String inputString = "12 2 + 3 4 - 5 6 - * *";

        System.out.println("Result : " + getEquivalentPostfixExpression(inputString));
    }

    private static int getEquivalentPostfixExpression(String inputString) {

        PushDownStack<Integer> operands = new PushDownStack<Integer>();
        String[] inputValues = inputString.split("\\s");

        for (String str : inputValues) {

            try {
                operands.push(Integer.parseInt(str));
            } catch (NumberFormatException numberFormatException) {

                int val2 = operands.pop();
                int val1 = operands.pop();

                switch (str) {
                    case "+":
                        operands.push(val2 + val1);
                        break;

                    case "-":
                        operands.push(val2 - val1);
                        break;

                    case "/":
                        operands.push(val2 / val1);
                        break;

                    case "*":
                        operands.push(val2 * val1);
                        break;
                }
            }
        }

        return operands.pop();
    }
}
