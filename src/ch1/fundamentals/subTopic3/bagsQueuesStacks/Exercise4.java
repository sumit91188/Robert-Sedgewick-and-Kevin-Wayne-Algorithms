package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownStack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Sumit Deo
 */
public class Exercise4 {

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

        if (isBalancedParentheses(inputString)) {
            System.out.println(inputString + " is a balanced String.");
        }
        else {
            System.out.println(inputString + " is not a balanced String.");
        }

        assertTrue(isBalancedParentheses("[()]{}{[()()]()}"));
        assertFalse(isBalancedParentheses("[(])"));
    }

    private static boolean isBalancedParentheses(String s) {

        PushDownStack<Character> stack = new PushDownStack<Character>();
        char[] inputChars = s.toCharArray();

        for (char inputChar : inputChars) {
            if ((inputChar == '{') || (inputChar == '[') || (inputChar == '(')) {
                stack.push(inputChar);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                char lastInserted = stack.pop();

                if ((inputChar == '}' && lastInserted != '{') ||
                        (inputChar == ']' && lastInserted != '[') ||
                        (inputChar == ')' && lastInserted != '(')) {
                    return false;
                }
            }
        }
        return true;
    }


}
