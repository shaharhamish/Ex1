/**
 * This class represents a solution for Ex1.
 * It provides functionality to convert, validate, and compare numbers in various bases (2-16).
 * Numbers are represented as strings in the format "<number><b><base>",
 * where the base can be specified as a digit (2-16) or a letter (A-F for 10-16).
 */
public class Ex1 {

    /**
     * Converts the given number (num) in a specified base to its decimal (base-10) representation.
     * If the input is not in a valid format, it returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return the integer value of the number in decimal, or -1 if invalid
     */
    public static int number2Int(String num) {
        if (num == null || num.isEmpty() || num.startsWith(" ")) return -1;

        // If there's no 'b', assume it's a decimal number
        if (!num.contains("b")) {
            try {
                return Integer.parseInt(num); // Parse as base-10 number
            } catch (NumberFormatException e) {
                return -1; // Return -1 for invalid format
            }
        }

        // Split the input into the number and base parts
        int baseIndex = num.lastIndexOf('b');
        String numberPart = num.substring(0, baseIndex).toUpperCase().trim();
        String basePart = num.substring(baseIndex + 1).trim();

        // Parse the base
        int base = parseBase(basePart);
        if (base < 2 || base > 16) return -1;

        // Convert the number part to decimal using the parsed base
        int result = 0;
        for (char c : numberPart.toCharArray()) {
            int digitValue = Character.digit(c, base);
            if (digitValue < 0) return -1; // Invalid character for the base
            result = result * base + digitValue;
        }

        return result;
    }

    /**
     * Checks if the given string (a) is a valid number in the format "<number><b><base>".
     *
     * @param a a String representing a number
     * @return true if the input is valid, false otherwise
     */
    public static boolean isNumber(String a) {
        if (a == null || a.isEmpty() || a.startsWith(" ")) return false;

        // If no 'b', check if it's a valid decimal number
        if (!a.contains("b")) {
            try {
                Integer.parseInt(a); // Attempt to parse as a base-10 number
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        // Split the input into the number and base parts
        int baseIndex = a.lastIndexOf('b');
        if (baseIndex <= 0 || baseIndex == a.length() - 1) return false; // Invalid format

        String numberPart = a.substring(0, baseIndex).toUpperCase().trim();
        String basePart = a.substring(baseIndex + 1).trim();

        // Parse the base
        int base = parseBase(basePart);
        if (base < 2 || base > 16) return false;

        // Validate the number part for the given base
        for (char c : numberPart.toCharArray()) {
            int digitValue = Character.digit(c, base);
            if (digitValue < 0 || (base > 9 && Character.isDigit(c) && digitValue >= base)) {
                return false; // Invalid character for the base
            }
        }

        return true;
    }

    /**
     * Parses the base string into an integer.
     * If the base is invalid, it returns -1.
     *
     * @param baseStr the base part of the number
     * @return the parsed base or -1 if invalid
     */
    private static int parseBase(String baseStr) {
        if (baseStr == null || baseStr.isEmpty()) return -1;

        if (baseStr.length() == 1 && Character.isLetter(baseStr.charAt(0))) {
            char baseChar = baseStr.charAt(0);
            if (baseChar >= 'A' && baseChar <= 'F') {
                return baseChar - 'A' + 10; // Convert A-F to 10-15
            }
        }

        try {
            int base = Integer.parseInt(baseStr);
            return (base >= 2 && base <= 9) ? base : -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Converts a decimal number (num) to a string representation in the specified base.
     *
     * @param num  the decimal number to convert
     * @param base the target base [2,16]
     * @return the string representation in the given base, or an empty string if invalid
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
     * Splits the input string into two separate numbers (num1 and num2).
     *
     * @param input a single string containing two numbers separated by a space
     * @return a String array containing the two numbers, or null if invalid
     */
    public static String[] splitNumbers(String input) {
        if (input == null || input.trim().isEmpty() || input.startsWith(" ")) return null;

        String[] parts = input.trim().split("\\s+");
        if (parts.length != 2) return null; // Ensure exactly two parts

        if (isNumber(parts[0]) && isNumber(parts[1])) {
            return parts; // Return the two numbers if both are valid
        }

        return null; // Return null if either part is invalid
    }

    /**
     * Checks if two numbers (n1, n2) have the same value.
     *
     * @param n1 the first number
     * @param n2 the second number
     * @return true if both numbers are equal in value, false otherwise
     */
    public static boolean equals(String n1, String n2) {
        int int1 = number2Int(n1);
        int int2 = number2Int(n2);

        // Return false if either number is invalid
        if (int1 == -1 || int2 == -1) {
            return false;
        }

        return int1 == int2;
    }

    /**
     * Finds the index of the largest number in the given array.
     * If multiple numbers have the same maximum value, returns the first occurrence.
     * Returns -1 if the array is null or empty.
     *
     * @param arr an array of strings representing numbers
     * @return the index of the largest number, or -1 if the array is null or empty
     */
    public static int maxIndex(String[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int value = number2Int(arr[i]);
            if (value > maxValue) {
                maxValue = value;
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
