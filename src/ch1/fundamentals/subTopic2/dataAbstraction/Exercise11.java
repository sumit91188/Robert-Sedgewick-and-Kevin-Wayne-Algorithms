package ch1.fundamentals.subTopic2.dataAbstraction;

/**
 * @author Sumit Deo
 */
public class Exercise11 {

    public static void main(String[] args) {

        try {
            System.out.println(new SmartDate(4, 18, 1989).toString());
            System.out.println(new SmartDate(2, 30, 2016).toString());
        }
        catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    static class SmartDate {

        private final int value;

        public SmartDate(int m, int d, int y) {
            if (!isValidDate(m, d, y)) {
                throw new RuntimeException("Invalid date");
            }
            value = y * 512 + m * 32 + d;
        }

        public int month() {
            return (value / 32) % 16;
        }

        public int day() {
            return value % 32;
        }

        public int year() {
            return value / 512;
        }

        public String toString() {
            return month() + "/" + day()
                    + "/" + year();
        }

        private boolean isValidDate(int month, int day, int year) {

            boolean isValidDate = true;
            int[] numberOfDaysEachMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (year > 0) {
                if (month > 0 && month < 13) {
                    if (day < 0 || day > numberOfDaysEachMonth[month - 1]) {
                        isValidDate = false;
                    }
                } else {
                    isValidDate = false;
                }
            }
            else {
                isValidDate = false;
            }
            return isValidDate;
        }
    }
}