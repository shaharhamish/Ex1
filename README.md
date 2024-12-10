# **Ex1: Number Format Converter and Calculator**

## **Overview**
This project provides tools to handle numbers in various bases (binary to hexadecimal, bases 2–16), represented in the format `<number><b><base>`. It offers seamless conversion between bases, along with additional utilities such as validation, comparison, and array operations. The program is designed to process complex input cases while ensuring accuracy and robustness.

## **Base Conversion**
The project supports conversions from any valid base (2–16) to decimal (base 10) and vice versa. For example:
- `number2Int("101b2")` converts the binary number `101` (base 2) to its decimal equivalent `5`.
- `int2Number(2748, 16)` converts the decimal number `2748` to the hexadecimal string `"ABCb16"`.
- Invalid inputs, such as `number2Int("123b20")` (unsupported base), return `-1`.
- Additional examples:
  - `int2Number(10, 2)` → `"1010b2"`
  - `number2Int("ABCb16")` → `2748`

## **Features**
- **Validation:** Checks if a number is in the correct format and rejects invalid inputs (e.g., `number2Int("123b")` → `-1`).
- **Comparison:** Compares numbers across different bases (`equals("101b2", "5b10")` → `true`).
- **Array Utilities:** Finds the index of the maximum number in an array (`maxIndex(["101b2", "10b10"])` → `0`).
- **Parsing:** Splits complex input strings into valid numbers (`splitNumbers("11b2 12b3")` → `["11b2", "12b3"]`).

## **Number Format**
- **Valid Numbers:** `<number><b><base>`
  - Examples:
    - `"101b2"` → Binary number 5.
    - `"123b10"` → Decimal number 123.
    - `"ABCb16"` → Hexadecimal number 2748.
- **Invalid Numbers:**
  - Leading/trailing spaces (e.g., `" 101b2"`).
  - Missing base (e.g., `"123b"`).
  - Unsupported bases (e.g., `"123b20"`).

## **Testing**
The project includes comprehensive unit and integration tests, covering valid inputs, invalid inputs, and edge cases to ensure reliability and accuracy in all scenarios.
