// Using Stack
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0, currentNumber = 0, sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                result += sign * currentNumber;
                currentNumber = 0;
                sign = (c == '+') ? 1 : -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * currentNumber;
                currentNumber = 0;
                result *= stack.pop(); // apply the sign before the parentheses
                result += stack.pop(); // apply the result before the parentheses
            }
        }

        result += sign * currentNumber; // add the last number
        return result;
    }
}

/*
The given code implements a solution to evaluate a basic mathematical expression string containing integers, 
the operators `+` and `-`, and parentheses `(` and `)`. It uses a stack to handle nested expressions within 
parentheses. The `currentNumber` variable accumulates the digits of a number as they are read, and `sign` 
tracks whether the current operation is addition or subtraction. When encountering `+` or `-`, the accumulated 
number is added to the result with the correct sign, and the `currentNumber` is reset. Parentheses are handled 
by saving the current `result` and `sign` onto the stack before starting a new sub-expression. On encountering 
`)`, the sub-expression result is calculated and combined with the saved state from the stack. Finally, any 
remaining number is added to the `result` before returning. This approach ensures proper evaluation of expressions 
with nested parentheses and multiple operations.
*/



// Using Recursion

// class Solution {
//     int idx; // This index traverses the string in one pass, at different levels of recursion

//     public int calculate(String s) {
//         idx = 0; // Initialize index to start from the beginning of the string
//         return calc(s);
//     }

//     private int calc(String s) {
//         int result = 0, num = 0, sign = 1; // Initialize result, current number, and sign (+1 for positive, -1 for
//                                            // negative)

//         while (idx < s.length()) {
//             char currentChar = s.charAt(idx++);

//             if (currentChar >= '0' && currentChar <= '9') {
//                 // If it's a digit, build the number (handle multi-digit numbers)
//                 num = num * 10 + currentChar - '0';
//             } else if (currentChar == '(') {
//                 // If it's an opening parenthesis, solve the sub-expression recursively
//                 num = calc(s);
//             } else if (currentChar == ')') {
//                 // If it's a closing parenthesis, return the result of the current
//                 // sub-expression
//                 return result + sign * num;
//             } else if (currentChar == '+' || currentChar == '-') {
//                 // If it's a '+' or '-', add the current number to the result with the current
//                 // sign
//                 result += sign * num;
//                 num = 0; // Reset num for the next number
//                 sign = (currentChar == '-') ? -1 : 1; // Update sign for the next number
//             }
//         }

//         // Add the last number (if any) to the result
//         return result + sign * num;
//     }
// }

/*
 * Explanation:
 * This code evaluates a mathematical expression represented as a string. It
 * handles addition, subtraction, and parentheses, ensuring correct precedence
 * and order of operations. The method calculate(String s) initializes an index
 * (idx) to keep track of the current position in the string while parsing it.
 * The helper method calc(String s) processes the string character by character,
 * updating the current number (num), result (result), and the sign of the
 * current operation (sign).
 * 
 * Digits: When encountering a digit, the code constructs multi-digit numbers by
 * multiplying the existing num by 10 and adding the new digit.
 * Parentheses: When encountering a (, the method recursively processes the
 * sub-expression inside the parentheses. When encountering a ), it returns the
 * computed result for that sub-expression.
 * Operators (+ or -): When encountering an operator, the code adds the current
 * num (multiplied by its sign) to result, resets num, and updates sign based on
 * the operator.
 * End of string: After the loop, the last number (if any) is added to result,
 * ensuring all numbers are accounted for.
 * This approach ensures that the expression is evaluated in one pass, handling
 * nested parentheses and operations correctly.
 */
