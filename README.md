
### **Ex1: Number Format Converter and Calculator**
#### **Overview**
This project provides a utility to convert, validate, and calculate with numbers represented in various bases (from binary to hexadecimal, bases 2–16). 
Numbers are represented as strings in the format <number><b><base>. 
The program includes functionality to compare numbers, find the maximum value in an array of numbers, and parse complex input strings.

#### **Features**
- **Base Conversion**:

-    Converts numbers from any valid base (2–16) to decimal (base 10).
-    Converts decimal numbers to any valid base (2–16).
-    
- **Validation:**:
 
-    Checks if a string is a valid number in the specified format.
-    Rejects invalid inputs, including numbers with spaces or unsupported bases.

- **Comparison:**:
  
    Compares two numbers (in any valid base) for equality.
    
- **Array Utilities**:
  
    Finds the index of the maximum number in an array of number strings.
    
- **Input Parsing**:
  
    Splits and processes complex input strings (e.g., "11b2 12b3" into two separate numbers).
  
#### **Number Format**
- **Valid Numbers**: <number><b><base>
**Examples**:
  
-    "101b2" → Binary representation of 5.
-    "123b10" → Decimal representation of 123.
-    "ABCb16" → Hexadecimal representation of 2748.
  
- **Base Representation**:
  
-    Bases 2–9: Only digits are allowed.
-    Bases 10–16: Digits 0–9 and letters A–F are allowed.

- **Invalid Numbers**:
  
-    Numbers with leading/trailing spaces (e.g., " 11b2", "11b2 ").
-    Numbers without a base (e.g., "123b").
-    Unsupported bases (e.g., "123b20").
-    Bases represented with digits greater than 9 (e.g., "123b12").
#### **Methods and Usage**
- **number2Int(String num)**:
  
-    Converts a number string in any valid base to its decimal equivalent.

    Input: A string in the format <number><b><base>.
    Output: Integer value in base 10, or -1 if invalid.
-    **Examples**:
  
    java
    Copy code
    System.out.println(Ex1.number2Int("101b2")); // Output: 5
    System.out.println(Ex1.number2Int("ABCb16")); // Output: 2748
    System.out.println(Ex1.number2Int("12b8"));   // Output: 10
    System.out.println(Ex1.number2Int("123b20")); // Output: -1 (invalid base)

- **isNumber(String a)**:
  
-    Checks if a string is a valid number in the format <number><b><base>.

    Input: A string.
    Output: true if valid, false otherwise.
-   **Examples**:
    
    java
    Copy code
    System.out.println(Ex1.isNumber("101b2")); // Output: true
    System.out.println(Ex1.isNumber(" 123b10")); // Output: false (leading space)
    System.out.println(Ex1.isNumber("123b"));   // Output: false (missing base)

- **int2Number(int num, int base)**:
  
-    Converts a decimal number to its representation in the specified base.

    Input:
    num: Decimal number.
    base: Target base (2–16).
    Output: A string in the format <number><b><base>, or an empty string if invalid.
    
-    **Examples**:
  
    java
    Copy code
    System.out.println(Ex1.int2Number(2748, 16)); // Output: "ABCb16"
    System.out.println(Ex1.int2Number(10, 2));   // Output: "1010b2"
    System.out.println(Ex1.int2Number(15, 10));  // Output: "15b10"

 -   **equals(String n1, String n2)**:
   
 -   Checks if two numbers in different bases are equivalent.

    Input: Two strings in the format <number><b><base>.
    Output: true if the numbers are equal, false otherwise.
-    **Examples**:

    java
    Copy code
    System.out.println(Ex1.equals("101b2", "5b10")); // Output: true
    System.out.println(Ex1.equals("ABCb16", "2748b10")); // Output: true
    System.out.println(Ex1.equals("123b10", "456b10"));  // Output: false
    
- **splitNumbers(String input)**:

-    Parses a string containing two numbers and splits them into two separate valid number strings.

    Input: A single string with two numbers separated by a space.
    Output: An array of two strings, or null if invalid.
-    **Examples**:
  
    java
    Copy code
    String[] result = Ex1.splitNumbers("11b2 12b3");
    System.out.println(Arrays.toString(result)); // Output: ["11b2", "12b3"]
    
    result = Ex1.splitNumbers("  11b2 12b3 ");
    System.out.println(Arrays.toString(result)); // Output: ["11b2", "12b3"]
    
    result = Ex1.splitNumbers("11b2");
    System.out.println(result); // Output: null (invalid)
- **maxIndex(String[] arr)**:
  
-  Finds the index of the maximum number in the given array.

  Input: An array of strings representing numbers.
  Output: Index of the largest number, or -1 if the array is empty or all numbers are invalid.
 - **Examples**:

  java
  Copy code
  String[] arr = {"11b2", "101b2", "10b2"};
  System.out.println(Ex1.maxIndex(arr)); // Output: 1
  
  arr = {"ABCb16", "2748b10", "5b10"};
  System.out.println(Ex1.maxIndex(arr)); // Output: 0

#### Testing:
Use the provided examples to test individual methods. Ensure inputs are correctly formatted, and edge cases (e.g., invalid formats, unsupported bases) are handled properly.

