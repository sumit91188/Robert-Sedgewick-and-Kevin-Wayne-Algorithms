package ch1.fundamentals.subTopic2.dataAbstraction;

/**
 * @author Sumit Deo
 */
public class Exercise7 {

    public static void main(String[] args) {

        String str = "Hello World";
        System.out.println(mystery(str));
    }

    private static String mystery(String s) {

        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(b) + mystery(a);
    }
}
