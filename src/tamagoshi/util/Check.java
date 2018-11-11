package tamagoshi.util;

/**
 * Classe making the data checks
 * @author Mathieu SERVIERE
 */
class Check {
    /**
     * Checks that a string is an integer.
     * @param str The string to validate
     * @return Is the string an integer?
     */
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }

        return true;
    }

    /**
     * Checks that a string is an integer greater than a given minimum.
     * @param str The string to check
     * @param min The minimum to check against
     * @return Are the conditions respected?
     */
    public static boolean isInteger(String str, int min) {
        if (!Check.isInteger(str)) {
            return false;
        }

        return Integer.parseInt(str) >= min;
    }

    /**
     * Checks that a string is an integer inside a given interval.
     * @param str The string to check
     * @param min The minimum to check against (null to ignore)
     * @param max The maximum to check against
     * @return Are the conditions respected?
     */
    public static boolean isInteger(String str, Integer min, int max) {
        if (!Check.isInteger(str)) {
            return false;
        }

        int nb = Integer.parseInt(str);

        if (min != null && nb < min) {
            return false;
        }

        return nb <= max;
    }
}