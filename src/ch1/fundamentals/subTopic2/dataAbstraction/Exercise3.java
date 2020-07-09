package ch1.fundamentals.subTopic2.dataAbstraction;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;

import java.util.HashMap;
import java.util.Random;

/**
 * @author Sumit Deo
 */
public class Exercise3 {

    private static Random random = new Random();
    private static HashMap<Interval2D, Interval1D[]> dHashMap = new HashMap<>();

    public static void main(String[] args) {

        //defaults values
        int nElem = 5;
        double min = 1.5;
        double max = 4.5;

        try {
            nElem = Integer.parseInt(args[0].trim());
            min = Double.parseDouble(args[1].trim());
            max = Double.parseDouble(args[2].trim());
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: Input needs to be in the form: int double double");
            nfe.printStackTrace();
            System.exit(0);
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("ArrayIndexOutOfBoundsException: Need 3 elements in the form: int double double");
            arrayIndexOutOfBoundsException.printStackTrace();
            System.exit(0);
        }

        if (min > max) {
            System.out.println("Seconds parameter must be less than the third one.");
            System.exit(0);
        }

        Interval2D[] ds = new Interval2D[nElem];

        generate2DIntervals(ds, min, max);

        drawChart(ds, min, max);

        printIntersectingPairs(ds);

        printPairsContainedInOneAnother(ds);
    }

    private static void printPairsContainedInOneAnother(Interval2D[] ds) {

        System.out.println("Intervals that are contained in one another...");
        for (int i = 0; i < ds.length - 1; i++) {
            for (int j = i + 1; j < ds.length; j++) {
                Interval1D[] ds1 = dHashMap.get(ds[i]);
                Interval1D[] ds2 = dHashMap.get(ds[j]);

                if ((ds1[0].min() > ds2[0].min()
                        && ds1[0].max() < ds2[0].max()
                        && ds1[1].min() > ds2[1].min()
                        && ds1[1].max() < ds2[1].max())
                        ||
                        (ds2[0].min() > ds1[0].min()
                                && ds2[0].max() < ds1[0].max()
                                && ds2[1].min() > ds1[1].min()
                                && ds2[1].max() < ds1[1].max())
                ) {
                    System.out.println("X: " + ds[i].toString() + "\tY: " + ds[j]);
                }
            }
        }
    }

    private static void drawChart(Interval2D[] ds, double min, double max) {

        StdDraw.setCanvasSize(512, 512);
        StdDraw.setPenRadius(.005);
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        for (int i = 0; i < ds.length; i++) {
            ds[i].draw();
        }
    }

    private static void printIntersectingPairs(Interval2D[] ds) {

        System.out.println("Printing intersecting pairs...");
        for (int i = 0; i < ds.length - 1; i++) {
            for (int j = i + 1; j < ds.length; j++) {
                if (ds[i].intersects(ds[j])) {
                    System.out.println("X: " + ds[i].toString() + "\tY: " + ds[j]);
                }
            }
        }
    }

    private static void generate2DIntervals(Interval2D[] ds, double min, double max) {

        for (int i = 0; i < ds.length; i++) {
            Interval1D x = generateIntervals(min, max);
            Interval1D y = generateIntervals(min, max);

            ds[i] = new Interval2D(x, y);
            dHashMap.put(ds[i], new Interval1D[]{x, y});
        }
    }

    private static Interval1D generateIntervals(double min, double max) {

        Interval1D interval1D;
        double x = min + (max - min) * random.nextDouble();
        double y = min + (max - min) * random.nextDouble();

        if (x <= y) {
            interval1D = new Interval1D(x, y);
        } else {
            interval1D = new Interval1D(y, x);
        }

        return interval1D;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
