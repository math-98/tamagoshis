package tamagoshi.util;

class Check {
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }

        return true;
    }

    public static boolean isInteger(String str, int min) {
        if (!Check.isInteger(str)) {
            return false;
        }

        return Integer.parseInt(str) >= min;
    }

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