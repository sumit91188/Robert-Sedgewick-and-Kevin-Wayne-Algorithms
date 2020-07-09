package ch1.fundamentals.subTopic1.basicProgrammingModel;

/**
 * @author Sumit Deo
 */
public class Exercise24 {

    public static void main(String[] args) {

        System.out.println("GCD of 105 & 24 is " + gcd(105, 24));

        try {
            int p = Integer.parseInt(args[0]);
            int q = Integer.parseInt(args[1]);
            System.out.println("GCD of " + p + " & " + q + " is " + gcd(p, q));
        }
        catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: Input needs to be integer.");
            nfe.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("ArrayIndexOutOfBoundsException: Needs 2 int inputs");
            arrayIndexOutOfBoundsException.printStackTrace();
        }

        System.out.println("GCD of 1111111 & 1234567 is " + gcd(1111111, 1234567));
    }

    private static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
}
