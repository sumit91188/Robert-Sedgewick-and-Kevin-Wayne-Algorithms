package fundamentals.basicProgrammingModel;

/**
 * @author Sumit Deo
 */
public class Exercise33 {

    public static void main(String[] args) {

        double[] x = {1,2,3};
        double[] y = {6,7,8};

        System.out.println("vector dot product " + dot(x, y));

        double[][] a = {{2,3,4},
                {4,3,2}};

        double[][] b = {{5,6,7},
                {6,5,4}};

        double[][] result = mult(a, b);

        System.out.println("matrix-matrix product");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }

        result = transpose(a);

        System.out.println("transpose");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }


        double[] multResult = mult(a, x);

        System.out.println("matrix-vector product");
        for (int i = 0; i < multResult.length; i++) {
            System.out.print(multResult[i] + "\t");
        }
        System.out.println();

        double[] z = {2,3};
        multResult = mult(z, a);

        System.out.println("vector-matrix product");
        for (int i = 0; i < multResult.length; i++) {
            System.out.print(multResult[i] + "\t");
        }

    }


    private static double[] mult(double[] y, double[][] a){

        if (y.length != a.length) {
            System.out.println("Array length mis-match.");
            return null;
        }

        double[] result = new double[a[0].length];
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < y.length; j++) {
                result[i] += a[j][i] * y[j];
            }
        }

        return result;
    }

    private static double[] mult(double[][] a, double[] x) {

        if (x.length != a[0].length) {
            System.out.println("Array length mis-match.");
            return null;
        }

        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < x.length; j++) {
                result[i] += a[i][j] * x[j];
            }
        }

        return result;
    }

    private static double[][] transpose(double[][] a) {

        double[][] result = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[j][i] = a[i][j];
            }
        }
        return result;
    }

    private static double dot(double[] x, double[] y) {
        double result = 0;
        if (x.length != y.length) {
            System.out.println("Array length mis-match.");
        }
        else {
            for (int i = 0; i < x.length; i++) {
                result = result + x[i] * y[i];
            }
        }
        return result;
    }

    private static double[][] mult(double[][] a, double[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            System.out.println("Array length mis-match.");
            return null;
        }

        double[][] result = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] * b[i][j];
            }
        }

        return result;
    }
}
