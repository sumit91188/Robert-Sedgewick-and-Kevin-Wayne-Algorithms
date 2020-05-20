package fundamentals.dataAbstraction;

/**
 * @author Sumit Deo
 */
public class Exercise4 {

    public static void main(String[] args) {

        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        System.out.println(string1);
        System.out.println(string2);
    }
}
