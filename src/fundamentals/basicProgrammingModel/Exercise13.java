package fundamentals.basicProgrammingModel;

/**
 * @author Sumit Deo
 */
public class Exercise13 {

    public static void main(String[] args) {

        int[][] ints = {{1,2,3,4},
                {5,6,7,8}};

        printTranspositionArray(ints);
    }

    private static void printTranspositionArray(int[][] ints) {

        for (int i = 0; i < ints[0].length; i++) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j][i] + " ");
            }
            System.out.println();
        }
    }
}
