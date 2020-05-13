package fundamentals.basicProgrammingModel;

/**
 * @author Sumit Deo
 */
public class Exercise19 {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {

            long[] fibArray;
            if (i == 0 || i == 1) {
                fibArray = new long[2];
            }
            else {
                fibArray = new long[i + 1];
            }

            fibArray[0] = 0;
            fibArray[1] = 1;
            System.out.println(i + " " + getFibonacci(i, fibArray));
        }
    }

    private static long getFibonacci(int n, long[] fibArray) {
        if (n == 0) {
            return fibArray[0];
        }
        else if (n == 1) {
            return fibArray[1];
        }

        for (int i = 2; i <= n; i++) {
            fibArray[i] = fibArray[i - 2] + fibArray[i - 1];
        }
        return fibArray[n];
    }
}
