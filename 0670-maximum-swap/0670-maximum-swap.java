class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;
        
        int[] lastIndex = new int[10];

        for (int i = 0; i < n; i++) {
            lastIndex[digits[i] - '0'] = i;  // Convert char to int index
        }

        // Iterate through the digits to find the first swap opportunity
        for (int i = 0; i < n; i++) {
            // Check for a larger digit from 9 down to the current digit
            for (int j = 9; j > digits[i] - '0'; j--) {
                if (lastIndex[j] > i) {
                    // Swap the digits
                    char temp = digits[i];
                    digits[i] = digits[lastIndex[j]];
                    digits[lastIndex[j]] = temp;

                    // Convert back to integer and return
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        
        // If no swap occurred, return the original number
        return num;
    }
}

//good question, revist this
// Example Walkthrough
// Let’s say we are processing the number 2736.

// Suppose we are at index 0 (digits[0] = '2').
// Current Digit: 2
// The loop will check:
// For digit = 9: lastIndex[9] is not greater than 0, skip.
// For digit = 8: lastIndex[8] is not greater than 0, skip.
// For digit = 7: lastIndex[7] is 1 (which is greater than 0), so:
// Swap 2 and 7:
// temp stores 2.
// digits[0] (which is 2) gets 7 from digits[1].
// digits[1] gets temp, which is 2.
// The array now looks like: ['7', '2', '3', '6'].
// The result 7236 is then returned.