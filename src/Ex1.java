/**
 * This class represents a simple solution for Ex1.
 * As defined here:
 * https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”,
 * “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        // אם הקלט לא מכיל 'b', נניח שזה מספר בבסיס 10
        if (!num.contains("b")) {
            try {
                return Integer.parseInt(num); // המרת המחרוזת למספר שלם בבסיס 10
            } catch (NumberFormatException e) {
                return -1; // אם לא מצליחים להמיר מספר לא תקין, מחזירים -1
            }
        }

        // אם כן יש 'b', ממשיכים לפי הקוד הקיים
        int baseIndex = num.lastIndexOf('b');
        String numberPart = num.substring(0, baseIndex);
        int base = Integer.parseInt(num.substring(baseIndex + 1));
        if (base == -1) return -1;

        int result = 0;
        for (char c : numberPart.toUpperCase().toCharArray()) {
            int digitValue = Character.digit(c, base);
            if (digitValue < 0) return -1; // Invalid digit for the base
            result = result * base + digitValue;
        }

        return result;
    }

    /**
     * This static function checks if the given String (g) is in a valid "number"
     * format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        // אם הקלט לא מכיל 'b', נבדוק אם מדובר במספר שלם בבסיס 10
        if (!a.contains("b")) {
            try {
                Integer.parseInt(a); // מנסים להמיר את המחרוזת למספר בבסיס 10
                return true; // אם הצלחנו להמיר, זהו מספר חוקי בבסיס 10
            } catch (NumberFormatException e) {
                return false; // אם לא הצלחנו להמיר, זה לא מספר חוקי
            }
        }

        // אם יש 'b', ממשיכים לפי הבדיקות הקודמות
        boolean ans = true;
        if (a == null || a.isEmpty()) return false;

        int baseIndex = a.lastIndexOf('b');
        if (baseIndex <= 0 || baseIndex == a.length() - 1) return false;

        String numberPart = a.substring(0, baseIndex);
        String basePart = a.substring(baseIndex + 1);

        // Validate base
        int base = parseBase(basePart);
        if (base < 2 || base > 16) return false;

        // Validate number part
        for (char c : numberPart.toUpperCase().toCharArray()) {
            if (Character.digit(c, base) < 0) return false; // Invalid character for the base
        }

        return true;
    }


    /**
     * Parses a base string into an integer.
     * Returns -1 if the base string is invalid.
     * @param baseStr the base part of the number
     * @return the parsed base or -1 if invalid
     */
    private static int parseBase(String baseStr) {
        if (baseStr == null || baseStr.isEmpty()) return -1;
        int base = 0;
        for (char c : baseStr.toCharArray()) {
            if (c < '0' || c > '9') return -1; // Hebrew: הבסיס חייב להיות מורכב ממספרים בלבד
            base = base * 10 + (c - '0');
        }
        return (base >= 2 && base <= 16) ? base : -1;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return ""
     * (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty
     * String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) return "";

        StringBuilder sb = new StringBuilder();

        do {
            int remainder = num % base;
            char digit = Character.forDigit(remainder, base);
            sb.append(digit);
            num /= base;
        } while (num > 0);

        return sb.reverse().toString().toUpperCase() + "b" + base;
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        // Validate numbers before comparing
        if (!isNumber(n1) || !isNumber(n2)) return false; // Hebrew: ודא שהמספרים חוקיים
        return number2Int(n1) == number2Int(n2);
    }

    /**
     * This static function search for the array index with the largest number
     * (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may
     * contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE; // Hebrew: התחלה עם ערך מינימלי

        for (int i = 0; i < arr.length; i++) {
            int value = number2Int(arr[i]);
            if (value > maxValue) {
                maxValue = value;
                maxIndex = i;
            }
        }
        return maxIndex; // Hebrew: החזר את האינדקס עם הערך המקסימלי
    }
}
