package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownQueue;

/**
 * @author Sumit Deo
 */
public class Exercise15 {

    public static void main(String[] args) {

        int k = 0;
        String inputString = "";

        try {
            k = Integer.parseInt(args[0].trim());
            inputString = args[1].trim();
        }
        catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: Input needs to be integer.");
            System.exit(0);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("ArrayIndexOutOfBoundsException: Needs 1st int input & 2nd String of multiple words");
            System.exit(0);
        }

        System.out.println(k + "th string from last of \"" + inputString + "\" is "  + getKthElm(k, inputString));
    }

    private static String getKthElm(int k, String inputString) {

        PushDownQueue<String> queue = new PushDownQueue<>();
        String[] inputStringArray = inputString.split("\\s");

        if (k > inputStringArray.length) {
            throw new RuntimeException("Invalid input");
        }

        for (String str : inputStringArray) {
            queue.enqueue(str);
        }

        for (int i = queue.size(); i > k; i--) {
            queue.dequeue();
        }
        return queue.dequeue();
    }
}
