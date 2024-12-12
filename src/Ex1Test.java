import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    Ex1 ex1 = new Ex1();

    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "0bA", "-3"};
        for (String s : good) {
            boolean ok = Ex1.isNumber(s);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "!@b2", "A", "1bb2"};
        for (String s : not_good) {
            boolean not_ok = Ex1.isNumber(s);
            assertFalse(not_ok);
        }
        // Invalid numbers
        assertFalse(Ex1.isNumber(null)); // Null input
        assertFalse(Ex1.isNumber("")); // Empty string
        assertFalse(Ex1.isNumber("12b")); // Missing base
        assertFalse(Ex1.isNumber("12b20")); // Base out of range
        assertFalse(Ex1.isNumber("G1b16")); // Invalid digit for base 16
        assertFalse(Ex1.isNumber("123bH")); // Invalid base character
    }

    @Test
    void int2NumberTest() {
        // Valid conversions from decimal to different bases
        assertEquals("1011b2", Ex1.int2Number(11, 2));   // Decimal 11 to binary
        assertEquals("1A7b16", Ex1.int2Number(423, 16)); // Decimal 423 to hexadecimal
        assertEquals("123b10", Ex1.int2Number(123, 10)); // Decimal 123 to decimal
        assertEquals("11b15", Ex1.int2Number(16, 15));   // Decimal 16 to base 15

        // Invalid cases: Base out of range
        assertEquals("", Ex1.int2Number(123, 1));        // Base less than 2
        assertEquals("", Ex1.int2Number(123, 17));       // Base greater than 16

        // Negative number case
        assertEquals("", Ex1.int2Number(-10, 2));        // Negative number

        // Edge cases
        assertEquals("0b2", Ex1.int2Number(0, 2));       // Zero in binary
        assertEquals("0b16", Ex1.int2Number(0, 16));     // Zero in hexadecimal
        assertEquals("1b16", Ex1.int2Number(1, 16));     // Minimum positive number in base 16
    }

    @Test
    void maxIndexTest() {
        // Normal case with positive numbers
        String[] arr1 = {"135b10", "100b10", "234b10"};
        assertEquals(2, Ex1.maxIndex(arr1));
        // Mixed case with zero and positive numbers
        String[] arr3 = {"-1b10", "0b10", "10b10"};
        assertEquals(2, Ex1.maxIndex(arr3));
        // All negative numbers
        String[] arr4 = {"-1b10", "-2b10", "-3b10"};
        assertEquals(-1, Ex1.maxIndex(arr4));
        // Empty array case
        String[] emptyArr = {};
        assertEquals(-1, Ex1.maxIndex(emptyArr));
        // Null array case
        String[] nullArr = null;
        assertEquals(-1, Ex1.maxIndex(nullArr));
        //Invalid arrays
        String[] arr5 = {"123", "invalid", "456"};
        assertEquals(2, Ex1.maxIndex(arr5)); // Skip invalid, largest is at index 2

    }

    @Test
    public void EqualsTest() {
        // Cases where numbers are not equivalent
        assertFalse(Ex1.equals("135b", "135b10"));
        assertFalse(Ex1.equals("100111b2", "63b10"));
        assertFalse(Ex1.equals("12345b6", "77b10"));
        assertFalse(Ex1.equals("135b", "136b10"));
        assertFalse(Ex1.equals("100111b2", "62b10"));
        assertFalse(Ex1.equals(null, ""));

        // Cases where numbers are equivalent
        assertTrue(Ex1.equals("135", "135b10"));
        assertTrue(Ex1.equals("011110b2", "30b10"));
        assertTrue(Ex1.equals("ABCb16", "2748"));
        assertTrue(Ex1.equals("0", "0b2"));
        assertTrue(Ex1.equals("1011bA", "1011bA"));
        assertTrue(Ex1.equals("012b10", "12b10")); // Test with leading zeros

        // Invalid inputs
        assertFalse(Ex1.equals(null, "123"));
        assertFalse(Ex1.equals("123", null));
        assertFalse(Ex1.equals(null, null));
    }

    @Test
    void edgeCasesTest() {
        assertEquals(0, Ex1.number2Int("0b2")); // Smallest valid binary
        assertEquals(0, Ex1.number2Int("0b10")); // Smallest valid decimal
        assertEquals(0, Ex1.number2Int("0b16")); // Smallest valid hexadecimal

        assertEquals(-1, Ex1.number2Int("")); // Empty string
        //assertEquals(-1, Ex1.number2Int(null)); // Null value

        assertEquals("", Ex1.int2Number(0, 1)); // Invalid base
        assertEquals("", Ex1.int2Number(-5, 10)); // Negative number
    }

    @Test
    void invalidInputsTest() {
        assertEquals(-1, Ex1.number2Int("invalid")); // Invalid input format
        assertEquals(-1, Ex1.number2Int("123b20")); // Base greater than 16
        assertEquals(-1, Ex1.number2Int("123b1")); // Base less than 2
        assertEquals(-1, Ex1.number2Int(null)); // Null input
    }

    @Test
    void conversionConsistencyTest() {
        int[] testValues = {0, 1, 42, 255, 1023}; // Test values
        int[] bases = {2, 8, 10, 16}; // Supported bases

        for (int value : testValues) {
            for (int base : bases) {
                // Convert to base representation and back to decimal
                String representation = Ex1.int2Number(value, base);
                int backToDecimal = Ex1.number2Int(representation);
                // Assert consistency
                assertEquals(value, backToDecimal, "Failed for value: " + value + " in base: " + base);
            }
        }
    }
}
