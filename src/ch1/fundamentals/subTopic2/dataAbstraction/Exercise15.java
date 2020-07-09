package ch1.fundamentals.subTopic2.dataAbstraction;

import edu.princeton.cs.algs4.In;

/**
 * @author Sumit Deo
 */
public class Exercise15 {

    private static final String FILE_NAME = "resources/1Kints.txt";

    public static void main(String[] args) {

        int[] ints = readInts(FILE_NAME);
        for (int i: ints) {
            System.out.println(i);
        }
    }

    private static int[] readInts(String fileName) {

        In in = new In(fileName);
        String input = in.readAll();

        String[] words = input.split("\n");
        int[] ints = new int[words.length];
        boolean isExceptionThrown = false;
        String badInputExceptionMsg = "Skipping bad input from the file: ";
        for (int i = 0; i < ints.length; i++) {
            try {
                ints[i] = Integer.parseInt(words[i].trim());
            }
            catch (NumberFormatException nfe) {
                isExceptionThrown = true;
                badInputExceptionMsg += words[i];
            }
        }

        if (isExceptionThrown) {
            System.out.println(badInputExceptionMsg);
        }

        return ints;
    }
}