package fundamentals.dataAbstraction;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

/**
 * @author Sumit Deo
 */
public class Exercise1 {

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

        Point2D[] point2DS = new Point2D[nElem];

        drawChart(point2DS);

        getClosestDistance(point2DS);

    }

    private static void getClosestDistance(Point2D[] point2DS) {

        double shortestDistance = Double.MAX_VALUE;
        double distance;
        String pointsString = null;

        //distance formula derived from Pythagorean theorem
        for (int i = 0; i < point2DS.length - 1; i++) {
            for (int j = i + 1; j < point2DS.length; j++) {
                distance = Math.sqrt(Math.pow((point2DS[i].x() - point2DS[j].x()), 2)
                + (Math.pow((point2DS[i].x() - point2DS[j].x()), 2)));

                if (distance < shortestDistance) {
                    pointsString = "(" + round(point2DS[i].x(), 2) + ", " + round(point2DS[i].y(), 2) + ") & " +
                            "("+ round(point2DS[j].x(), 2) + ", " + round(point2DS[j].y(), 2) + ")";
                    shortestDistance = distance;
                }
            }
        }
        System.out.printf("The distance separating the closest pair of points " + pointsString +
                " is %.3f\n", shortestDistance);
    }

    private static void drawChart(Point2D[] point2DS) {

        StdDraw.setCanvasSize(512, 512);
        StdDraw.setPenRadius(.015);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        for (int i = 0; i < point2DS.length; i++) {
            double xCd = Math.random();
            double yCd = Math.random();

            point2DS[i] = new Point2D(xCd, yCd);
            String pointCoed = "(" + round(point2DS[i].x(), 2) + ", " + round(point2DS[i].y(), 2) + ")";
            StdDraw.text(xCd, yCd, pointCoed);
        }
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
