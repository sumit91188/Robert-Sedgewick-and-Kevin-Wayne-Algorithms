package fundamentals.dataAbstraction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Sumit Deo
 */
public class Exercise19_Date {

    public static void main(String[] args) throws ParseException {

        SmartDate date = null;
        try {
            date = new SmartDate("9/11/1988");
        }
        catch (RuntimeException e) {
            e.printStackTrace();
        }

        System.out.println("It's " + date.dayOfTheWeek() + " on " + date.toString());
    }

    static class SmartDate {

        private final int value;

        public SmartDate(int m, int d, int y) {
            if (!isValidDate(m, d, y)) {
                throw new RuntimeException("Invalid date");
            }
            value = y * 512 + m * 32 + d;
        }

        public SmartDate(String dateString) {

            String[] data = dateString.split("/");

            int m = Integer.parseInt(data[0].trim());
            int d = Integer.parseInt(data[1].trim());
            int y = Integer.parseInt(data[2].trim());

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

        private String dayOfTheWeek() throws ParseException {

            String dateString = String.format("%d-%d-%d", year(), month(), day());
            Date date = new SimpleDateFormat("yyyy-M-d").parse(dateString);
            String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
            return dayOfWeek;
        }
    }
}