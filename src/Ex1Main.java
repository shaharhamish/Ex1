import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement
 * all needed functions.
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit"; // משתנים לאחסון מספרי הקלט ואפשרות הסיום

        while (!num1.equals(quit)) { // לולאה ראשית שפועלת עד שהמשתמש מזין "quit"
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next(); // קלט של המספר הראשון
            if (num1.equals(quit)) { // בדיקת סיום התוכנית
                break;
            }

            // בדיקה אם המספר הראשון הוא בפורמט חוקי
            if (!Ex1.isNumber(num1)) {
                System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                continue; // מדלג על המשך הלולאה במקרה של קלט שגוי
            }

            // הצגת הערך של המספר הראשון
            System.out.println("num1= " + num1 + " is number: true , value: " + Ex1.number2Int(num1));

            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next(); // קלט של המספר השני
            if (num2.equals(quit)) { // בדיקת סיום התוכנית
                break;
            }

            // בדיקה אם המספר השני הוא בפורמט חוקי
            if (!Ex1.isNumber(num2)) {
                System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                continue; // מדלג על המשך הלולאה במקרה של קלט שגוי
            }

            // הצגת הערך של המספר השני
            System.out.println("num2= " + num2 + " is number: true , value: " + Ex1.number2Int(num2));

            System.out.println("Enter a base for output: (a number [2,16]) ");
            int base = sc.nextInt(); // קלט עבור הבסיס המבוקש
            if (base < 2 || base > 16) { // בדיקת טווח חוקי של הבסיס
                System.out.println("ERR: base must be in the range [2,16]");
                continue; // מדלג על המשך הלולאה במקרה של בסיס שגוי
            }

            // חישוב והצגת תוצאות
            int value1 = Ex1.number2Int(num1); // המרת המספר הראשון לערך עשרוני
            int value2 = Ex1.number2Int(num2); // המרת המספר השני לערך עשרוני
            System.out.println(num1 + " + " + num2 + " = " + Ex1.int2Number(value1 + value2, base)); // הצגת חיבור
            System.out.println(num1 + " * " + num2 + " = " + Ex1.int2Number(value1 * value2, base)); // הצגת כפל

            // חישוב המספר הגדול ביותר
            String[] arr = {num1, num2, Ex1.int2Number(value1 + value2, base), Ex1.int2Number(value1 * value2, base)};
            int maxIndex = Ex1.maxIndex(arr); // מציאת האינדקס של הערך המקסימלי
            System.out.println("Max number over " + java.util.Arrays.toString(arr) + " is: " + arr[maxIndex]);
        }

        // סיום התוכנית
        System.out.println("quitting now...");
        sc.close(); // סגירת Scanner
    }
}
