package ch1.fundamentals.subTopic1.basicProgrammingModel;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Sumit Deo
 */
public class Exercise36 {

    public static void main(String[] args) {

        int m = 6; //default value
        int n = 10; //default value
        try {
            m = Integer.parseInt(args[0].trim());
            n = Integer.parseInt(args[1].trim());
        }
        catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: Input needs to be integer.");
            nfe.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("ArrayIndexOutOfBoundsException: Needs two int inputs");
            arrayIndexOutOfBoundsException.printStackTrace();
        }

        double[][] results = new double[n][m];
        double[] a = new double[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[j] = j;
            }

            shuffle(a);

            for (int j = 0; j < m; j++) {
                results[i][j] = a[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print((int) results[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void shuffle(double[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        { // Exchange a[i] with random element in a[i..N-1]
            int r = i + StdRandom.uniform(N-i);
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
}
