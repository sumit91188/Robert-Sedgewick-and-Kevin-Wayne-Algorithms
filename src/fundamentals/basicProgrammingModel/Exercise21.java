package fundamentals.basicProgrammingModel;

import edu.princeton.cs.algs4.In;

/**
 * @author Sumit Deo
 */
public class Exercise21 {

    public static void main(String[] args) {

        In in = new In();
        boolean needToPrintHeaders = true;
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] values = line.split(" ");
            printLines(values, needToPrintHeaders);
            needToPrintHeaders = false;
        }
    }

    private static void printLines(String[] values, boolean printHeaders) {
        if (printHeaders) {
            System.out.println("Name\tValue1\tValue2\tResult");
        }
        System.out.print(values[0] + "\t");
        System.out.print(values[1] + "\t\t");
        System.out.print(values[2] + "\t\t");

        double value1 = Double.parseDouble(values[1]);
        double value2 = Double.parseDouble(values[2]);
        double result = value1/value2;
        System.out.format("%.3f", result);
        System.out.println();
    }
}
