package fundamentals.dataAbstraction;

/**
 * @author Sumit Deo
 */
public class Exercise6 {

    public static void main(String[] args) {

        String str1 = "ACTGACG";
        String str2 = "TGACGAC";

        if (isCircularShift(str1, str2)) {
            System.out.println(str1 + " is a circular shift of " + str2 + ", and vice versa.");
        }
        else {
            System.out.println(str1 + ", " + str2 + " do not share circular-shift relationship.");
        }
    }

    private static boolean isCircularShift(String str1, String str2) {

        if (str1.length() == str2.length() && (str1 + str1).contains(str2)) {
            return true;
        }
        return false;
    }
}
