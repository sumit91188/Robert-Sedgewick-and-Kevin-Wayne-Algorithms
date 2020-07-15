package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownStack;

/**
 * @author Sumit Deo
 */
public class Exercise10 {

    public static void main(String[] args) {
        String inputString = "( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )";

        System.out.println("Result : " + getEquivalentPostfixExpression(inputString));
    }

    private static String getEquivalentPostfixExpression(String inputString) {

        PushDownStack<String> operands = new PushDownStack<String>();
        PushDownStack<String> operators = new PushDownStack<String>();
        String[] inputValues = inputString.replaceAll("\\s", "").split("\\s*");

        for (String str : inputValues) {
            if (str.equals("(")) {
                continue;
            }
            else if (str.equals("*") || (str.equals("/")) || (str.equals("+")) || (str.equals("-"))) {
                operators.push(str);
            }
            else if (str.equals(")")) {
                String operator = operators.pop();
                String value2 = operands.pop();
                String value1 = operands.pop();

                String eqExp = value1 + " " + value2 + " " + operator;
                operands.push(eqExp);
            }
            else {
                operands.push(str);
            }
        }
        return operands.pop();
    }
}
