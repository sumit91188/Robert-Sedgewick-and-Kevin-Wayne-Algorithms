package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownStack;

/**
 * @author Sumit Deo
 */
public class Exercise9 {

    public static void main(String[] args) {
        String inputString = null;

        try {
            inputString = args[0].trim();
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("ArrayIndexOutOfBoundsException: Needs an input");
            arrayIndexOutOfBoundsException.printStackTrace();
            System.exit(0);
        }

        System.out.println("Result - " + getEquivalentInfixExpression(inputString));
    }

    private static String getEquivalentInfixExpression(String inputString) {

        PushDownStack<String> operands = new PushDownStack<String>();
        PushDownStack<String> operators = new PushDownStack<String>();
        String[] inputValues = inputString.split("\\s");

        for (String str : inputValues) {
            if (str.equals("(")) {

            }
            else if (str.equals("*") || (str.equals("/")) || (str.equals("+")) || (str.equals("-"))) {
                operators.push(str);
            }
            else if (str.equals(")")){
                String operator = operators.pop();
                String value2 = operands.pop();
                String value1 = operands.pop();

                String eqExp = " (" + value1 + operator + value2 + ") ";
                operands.push(eqExp);
            }
            else {
                operands.push(str);
            }
        }
        return operands.pop();
    }
}
