package ch1.fundamentals.subTopic1.basicProgrammingModel;

/**
 * @author Sumit Deo
 */
public class Exercise18 {

    public static void main(String[] args) {

        System.out.println(mystery(2,25));
        System.out.println(mystery(3,11));
        System.out.println(mysteryCopy(2,25));
        System.out.println(mysteryCopy(3,11));
    }

    private static int mystery(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return mystery(a + a, b / 2);
        }
        return mystery(a + a, b / 2) + a;
    }

    private static int mysteryCopy(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            return mysteryCopy(a * a, b/2);
        }
        return mysteryCopy(a * a, b / 2) * a;
    }
}
