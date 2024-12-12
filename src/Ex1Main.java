import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement
 * all needed functions.
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit"; // Variables to store input numbers and end option

        while (!num1.equals(quit) && !num2.equals(quit)) { // A main loop that runs until the user enters "quit"
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next(); // getting first number
            if (num1.equals(quit)) { //checking quiting
                break;
            }

            // checking if the first num is valid
            if (!Ex1.isNumber(num1) || isNegative(num1)) {
                System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                continue; // skipping the rest of the loop
            }

            // showing the first value
            System.out.println("num1= " + num1 + " is number: true , value: " + Ex1.number2Int(num1));

            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next(); // input the second number
            if (num2.equals(quit)) { // checking quiting
                break;
            }

            // checking if the second number is valid
            if (!Ex1.isNumber(num2) || isNegative(num1)) {
                System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                continue; // skipping the rest of the loop
            }

            // showing the second number
            System.out.println("num2= " + num2 + " is number: true , value: " + Ex1.number2Int(num2));

            System.out.println("Enter a base for output: (a number [2,16]) ");
            int base = sc.nextInt(); // getting the required base
            if (base < 2 || base > 16) { // Checking the valid range of the base
                System.out.println("ERR: wrong base, should be [2,16], got (" + base + ")");
                continue; // Skips the continuation of the loop in case of an incorrect base
            }
            // Calculation and display of results
            int value1 = Ex1.number2Int(num1); // Convert the first number to a decimal value
            int value2 = Ex1.number2Int(num2); // Convert the second number to a decimal value
            System.out.println(num1 + " + " + num2 + " = " + formatResult(value1 + value2, base)); // showing sum
            System.out.println(num1 + " * " + num2 + " = " + formatResult(value1 * value2, base)); //showing multiplication

            // calculating the max number
            String[] arr = {num1, num2, Ex1.int2Number(value1 + value2, base), Ex1.int2Number(value1 * value2, base)};
            int maxIndex = Ex1.maxIndex(arr); // finding the max value index
            System.out.println("Max number over " + java.util.Arrays.toString(arr) + " is: " + arr[maxIndex]);
        }

        // ending the program
        System.out.println("quitting now...");
        sc.close(); // closing the Scanner
    }

    private static String formatResult(int result, int base) {
        if (base == 10) {
            return String.valueOf(result); // בסיס 10 - ללא סיומת
        }
        return Ex1.int2Number(result, base); // בסיס אחר - עם סיומת
    }

    /**
     * פונקציה שבודקת אם מספר הוא שלילי.
     *
     * @param num המספר לבדיקה
     * @return true אם המספר שלילי, אחרת false
     */
    private static boolean isNegative(String num) {
        return num.startsWith("-");
    }
}