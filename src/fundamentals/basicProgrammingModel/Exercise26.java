package fundamentals.basicProgrammingModel;

/**
 * @author Sumit Deo
 */
public class Exercise26 {

    public static void main(String[] args) {

        int a = 20;
        int b = 10;
        int c = 30;
        int t = 0;

        if (a > b) {
            t = a;
            a = b;
            b = t;
        }
        if (a > c) {
            t = a;
            a = c;
            c = t;
        }
        if (b > c) {
            t = b;
            b = c;
            c = t;
        }

        System.out.println("a) " + a);
        System.out.println("b) " + b);
        System.out.println("c) " + c);
    }
}
