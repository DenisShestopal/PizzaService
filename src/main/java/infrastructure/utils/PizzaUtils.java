package infrastructure.utils;

public class PizzaUtils {

    public static boolean isAllowedPercentage(int percentage) {
        return ((percentage >= 1) && (percentage <= 100));
    }

    public static double getPercentageOfNumber(double number, int percentage) {
        return (number * ((double) percentage / 100));
    }
}
