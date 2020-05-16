package fundamentals.basicProgrammingModel;

/**
 * @author Sumit Deo
 */
public class Exercise5 {

    public static void main(String[] args) {

        isBetween0and1(0.2, 0.9);
        isBetween0and1(1, 0);
        isBetween0and1(0.02, 0);
    }

    private static void isBetween0and1(double x, double y) {
        System.out.println(x > 0 && x < 1 && y > 0 && y < 1);
    }
}
