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
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }
        @Test
        void int2NumberTest() {
            assertEquals(11, Ex1.number2Int("1011b2"));
            assertEquals(423, Ex1.number2Int("1A7b16"));
            assertEquals(-1, Ex1.number2Int("123b20")); // Invalid base
            assertEquals(-1, Ex1.number2Int("1bb2"));   // Invalid format
            assertEquals(-1, Ex1.number2Int(""));   // empty string
        }

        @Test
        void maxIndexTest() {
            String[] arr1 = {"135b", "100b", "234b"};
            assertEquals(2, Ex1.maxIndex(arr1));

            String[] arr2 = {"135b", null, "234b"};
            assertEquals(2, Ex1.maxIndex(arr2));

            String[] arr3 = {"-1b10", "0b10", "10b10"};
            assertEquals(2, Ex1.maxIndex(arr3));

            String[] arr4 = {"-1b10", "-2b10", "-3b10"};
            assertEquals(0, Ex1.maxIndex(arr4));

            String[] emptyArr = {};
            assertEquals(-1, Ex1.maxIndex(emptyArr));

            String[] nullArr = null;
            assertEquals(-1, Ex1.maxIndex(nullArr));
//            String [] good = {"45", "fgh" , "558" , "a" , "1" , "fd45" , "23"};
//            for (int i = 0; i < good.length; i++) {
//                int maxindex = ex1.maxIndex(good);
//                assertTrue(ok);
//            }
//
//            String [] not_good = {};
//            for (int i = 0; i < not_good.length; i++) {
//                int maxindex = ex1.maxIndex(not_good);
//                assertFalse(not_ok);
//            }
        }

    @Test
    public void testEquals() {
        assertTrue(Ex1.equals("135b", "135b10"));
        assertTrue(Ex1.equals("100111b2", "63b10"));
        assertTrue(Ex1.equals("12345b6", "77b10"));

        assertFalse(Ex1.equals("135b", "136b10"));
        assertFalse(Ex1.equals("100111b2", "62b10"));

        assertTrue(Ex1.equals("012b10", "12b10")); // Test with leading zeros
    }

    @Test
    void edgeCasesTest() {
        assertEquals(0, Ex1.number2Int("0b2")); // Smallest valid binary
        assertEquals(0, Ex1.number2Int("0b10")); // Smallest valid decimal
        assertEquals(0, Ex1.number2Int("0b16")); // Smallest valid hexadecimal

        assertEquals(-1, Ex1.number2Int("")); // Empty string
        assertEquals(-1, Ex1.number2Int(null)); // Null value

        assertEquals("", Ex1.int2Number(0, 1)); // Invalid base
        assertEquals("", Ex1.int2Number(-5, 10)); // Negative number
    }
        // Add additional test functions - test as much as you can.
    }
