public class Solution {
    public int maximumLength(String s) {
        int n = s.length(); // Length of the string
        int low = 1, high = n; // Range of possible lengths

        // If the smallest length doesn't satisfy the condition, return -1
        if (!canFormValidSubstring(s, n, low)) return -1;

        // Perform binary search to find the maximum valid length
        while (low + 1 < high) {
            int mid = (low + high) / 2; // Midpoint of current range
            if (canFormValidSubstring(s, n, mid)) {
                low = mid; // Mid is valid; try longer substrings
            } else {
                high = mid; // Mid is invalid; try shorter substrings
            }
        }

        return low; // Return the maximum valid length
    }

    // Helper function to check if a substring of length x satisfies the condition
    private boolean canFormValidSubstring(String s, int n, int x) {
        int[] freq = new int[26]; // Frequency count for characters 'a' to 'z'
        int start = 0; // Start pointer of the sliding window

        // Traverse the string
        for (int end = 0; end < n; end++) {
            // Move start pointer until characters match
            while (s.charAt(start) != s.charAt(end)) start++;

            // Check if the current window length is at least x
            if (end - start + 1 >= x) {
                freq[s.charAt(end) - 'a']++; // Increment frequency of the character
            }

            // If any character's frequency exceeds 2, return true
            if (freq[s.charAt(end) - 'a'] > 2) return true;
        }

        return false; // No valid substring found
    }
}
