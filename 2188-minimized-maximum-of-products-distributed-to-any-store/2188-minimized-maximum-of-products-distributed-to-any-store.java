public class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = 0;
        
        // Find the maximum quantity in quantities array as the initial right bound
        for (int quantity : quantities) {
            right = Math.max(right, quantity);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(mid, n, quantities)) {
                right = mid;  // Try to minimize x further
            } else {
                left = mid + 1;  // Increase x
            }
        }
        return left;  // This is the minimum possible x
    }

    // Optimized distribution check
    private boolean canDistribute(int x, int n, int[] quantities) {
        int storesNeeded = 0;
        for (int quantity : quantities) {
            storesNeeded += (quantity + x - 1) / x;  // Efficient calculation of Math.ceil(quantity / x)
            if (storesNeeded > n) {
                return false;  // Not enough stores to handle this distribution
            }
        }
        return true;
    }
}
