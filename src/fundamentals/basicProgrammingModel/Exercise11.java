package fundamentals.basicProgrammingModel;

/**
 * @author Sumit Deo
 */
public class Exercise11 {

    public static void main(String[] args) {

        boolean[][] booleans = {{true, false, true, false},
                {false, true, false, true}};

        printArray(booleans);
    }

    private static void printArray(boolean[][] booleans) {

        for (int i = 0; i < booleans.length; i++) {
            for (int j = 0; j < booleans[0].length; j++) {
                if (booleans[i][j]) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
