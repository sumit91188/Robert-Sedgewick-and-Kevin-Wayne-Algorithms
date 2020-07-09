package ch1.fundamentals.subTopic1.basicProgrammingModel;

/**
 * @author Sumit Deo
 */
public class Exercise9 {

    public static void main(String[] args) {

        System.out.println(parseToBinaryString(32));
        System.out.println(parseToBinaryString(8));
        System.out.println(parseToBinaryString(16));
    }

    private static String parseToBinaryString(int n) {
        String binaryString = "";
        for (int i = n; i > 0; i /= 2) {
            binaryString = (i % 2) + binaryString;
        }
        return binaryString;
    }
}
