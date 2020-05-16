package fundamentals.basicProgrammingModel;

/**
 * @author Sumit Deo
 */
public class Exercise14 {

    public static void main(String[] args) {

        int num = 33;
        System.out.println(lg(num));
    }

    private static int lg(int num) {
        int result = 0;
        while (num > 0) {
            num = num / 2;
            result++;
        }
        return result - 1;
    }
}
