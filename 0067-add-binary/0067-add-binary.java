class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0; // Initialize pointers and carry

        while (i >= 0 || j >= 0) { // Loop through both strings from the end to the beginning
            int sum = carry; // Start with the carry from the previous addition, if any
            if (j >= 0)
                sum += b.charAt(j--) - '0'; // Add digit from b if available
            if (i >= 0)
                sum += a.charAt(i--) - '0'; // Add digit from a if available
            sb.append(sum % 2); // Append the result of sum % 2 (binary addition result)
            carry = sum / 2; // Update carry for the next bit addition
        }

        if (carry != 0)
            sb.append(carry); // If there's leftover carry, append it

        return sb.reverse().toString(); // Reverse the result to get the final binary string
    }

}
