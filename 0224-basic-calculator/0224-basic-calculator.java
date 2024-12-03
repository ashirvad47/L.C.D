class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentTotal = 0;
        int currentNumber = 0;
        int sign = 1; // Start with a positive sign

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                // Build the current number efficiently
                currentNumber = currentNumber * 10 + (c - '0');
            } else if (c == '+') {
                // Apply the previous sign and number, then reset
                currentTotal += sign * currentNumber;
                currentNumber = 0;
                sign = 1; // Update for the next operation
            } else if (c == '-') {
                // Apply the previous sign and number, then reset
                currentTotal += sign * currentNumber;
                currentNumber = 0;
                sign = -1; // Update for the next operation
            } else if (c == '(') {
                // Push the current total and sign to the stack, reset for inner parentheses
                stack.push(currentTotal);
                stack.push(sign);
                currentTotal = 0;
                sign = 1;
            } else if (c == ')') {
                // Apply the last number before closing parentheses
                currentTotal += sign * currentNumber;
                currentNumber = 0;
                // Pop the sign and previous total, and combine them
                currentTotal *= stack.pop(); // Apply the sign
                currentTotal += stack.pop(); // Add the total before parentheses
            }
            // Ignore spaces automatically
        }

        // Add any remaining number to the total
        currentTotal += sign * currentNumber;

        return currentTotal;
    }
}