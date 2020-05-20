package fundamentals.dataAbstraction;

import edu.princeton.cs.algs4.Interval1D;

/**
 * @author Sumit Deo
 */
public class Exercise2 {

    public static void main(String[] args) {

        int nElem = 10; //default
        try {
            nElem = Integer.parseInt(args[0].trim());
        }
        catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: Input needs to be integer.");
            nfe.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("ArrayIndexOutOfBoundsException: Needs an int input");
            arrayIndexOutOfBoundsException.printStackTrace();
        }

        Interval1D[] ds = new Interval1D[nElem];

        generateIntervals(ds);

        printIntersectingPairs(ds);
    }

    private static void printIntersectingPairs(Interval1D[] ds) {

        System.out.println("Printing intersecting pairs...");
        for (int i = 0; i < ds.length - 1; i++) {
            for (int j = i + 1; j < ds.length; j++) {
                if (ds[i].intersects(ds[j])) {
                    System.out.printf("(%.3f, %.3f) intersecting with (%.3f, %.3f)\n",
                            ds[i].min(), ds[i].max(), ds[j].min(), ds[j].max());
                }
            }
        }
    }

    private static void generateIntervals(Interval1D[] ds) {

        for (int i = 0; i < ds.length; i++) {
            double x = Math.random();
            double y = Math.random();

            if (x <= y) {
                ds[i] = new Interval1D(x, y);
            }
            else {
                ds[i] = new Interval1D(y, x);
            }
        }
    }
}
