package fundamentals.basicProgrammingModel;

/**
 * @author Sumit Deo
 */
public class Exercise30 {

    public static void main(String[] args) {

        boolean[][] booleans = new boolean[15][15];

        for (int i = 0; i < booleans.length; i++) {
            for (int j =0; j < booleans[0].length; j++) {
                booleans[i][j] = areCoPrime(i, j);
            }
        }

        for (int i = 0; i < booleans.length; i++) {
            for (int j =0; j < booleans[0].length; j++) {
                System.out.print(booleans[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static boolean areCoPrime(int i, int j) {

        if (i == j || i == 0 || j == 0 || i == 1 || j == 1) {
            return false;
        }
        else {
            return gcd(i, j) == 1;
        }
    }

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
}
