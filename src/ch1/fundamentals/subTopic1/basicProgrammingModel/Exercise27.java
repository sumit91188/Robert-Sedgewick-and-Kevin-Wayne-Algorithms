package ch1.fundamentals.subTopic1.basicProgrammingModel;

/**
 * @author Sumit Deo
 */
public class Exercise27 {

    private static int count = 0;
    public static void main(String[] args) {

        /*binomial(100, 50, 0.9);
        System.out.println("Number of iterations: " + count);*/

        int n = 100;
        int k = 50;

        double[][] arr = new double[n + 1][k + 1];

        System.out.println(enhancedBinomial(arr, n, k, 0.9));
        System.out.println("Number of iterations: " + count);
    }

    private static double binomial(int N, int k, double p) {
        count++;
        if ((N == 0) || (k < 0)) return 1.0;
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    private static double enhancedBinomial(double[][] arr, int n, int k, double p) {
        count++;
        if ((n == 0) || (k < 0)) {
            return 1.0;
        }
        if (arr[n][k] == 0.0) {
            arr[n][k] = (1.0 - p) * enhancedBinomial(arr, n - 1, k, p) + p * enhancedBinomial(arr, n - 1, k - 1, p);
        }
        return arr[n][k];
    }
}
