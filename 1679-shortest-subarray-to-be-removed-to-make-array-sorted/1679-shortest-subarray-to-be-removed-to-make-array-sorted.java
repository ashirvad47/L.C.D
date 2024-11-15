public class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        
        // Step 1: Find the longest increasing prefix
        int left = 0;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        
        // If the whole array is non-decreasing, no need to remove anything
        if (left == n - 1) {
            return 0;
        }
        
        // Step 2: Find the longest increasing suffix
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        
        // Step 3: Minimum length is either removing prefix or suffix
        int minRemove = Math.min(n - left - 1, right);
        
        // Step 4: Try merging prefix and suffix by removing a middle subarray
        int i = 0;
        int j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                minRemove = Math.min(minRemove, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        
        return minRemove;
    }
}
