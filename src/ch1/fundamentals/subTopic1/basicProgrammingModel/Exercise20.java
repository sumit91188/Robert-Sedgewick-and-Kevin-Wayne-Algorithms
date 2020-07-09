package ch1.fundamentals.subTopic1.basicProgrammingModel;

/**
 * @author Sumit Deo
 */
public class Exercise20 {

    public static void main(String[] args) {

        System.out.println(getFactorial(10));
    }

    private static long getFactorial(int i) {
        if (i == 1) {
            return 1;
        }
        return i * getFactorial(i - 1);
    }
}
