public class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = 0;
        
        // Find the maximum quantity in quantities array as the initial right bound
        for (int quantity : quantities) right = Math.max(right, quantity);

        // Perform binary search to find the minimum possible x
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(mid, n, quantities)) right = mid;  // Try to minimize x further
            else left = mid + 1;  // Increase x
        }
        return left;  // This is the minimum possible x
    }

    // Optimized distribution check
    private boolean canDistribute(int x, int n, int[] quantities) {
        int storesNeeded = 0;
        for (int quantity : quantities) {
            storesNeeded += (quantity + x - 1) / x;  // Efficient calculation of Math.ceil(quantity / x)
            if (storesNeeded > n) return false;  // Not enough stores to handle this distribution
        }
        return true;
    }
}

/*
### Explanation Summary:
The goal is to minimize the maximum number of products (`x`) assigned to any store, given `n` stores and an array `quantities` representing the product count for each type. Using binary search, we iteratively narrow down the smallest possible `x` by checking if it's feasible to distribute the products such that no store has more than `x` units. 

1. **Binary Search Setup**: 
   - `left` starts at 1 (smallest possible value for `x`).
   - `right` is the maximum value in `quantities`, assuming one store might need to take all units of a product type.

2. **Binary Search Process**:
   - Calculate `mid` as the potential maximum units per store (`x`).
   - Use the `canDistribute(mid, n, quantities)` function to check if this `mid` value allows feasible distribution.
   - If `mid` is feasible, adjust `right = mid` to minimize `x`. If not, increase `left = mid + 1`.

3. **Distribution Check (`canDistribute` Function)**:
   - For each product type, calculate the number of stores needed to hold `quantity` units with an upper limit of `x` units per store using `(quantity + x - 1) / x`, an efficient way of calculating `Math.ceil(quantity / x)`.
   - If the total `storesNeeded` exceeds `n`, distribution is not feasible for that `x`.
   
4. **End Result**:
   - When `left` equals `right`, we've found the minimum possible `x` for balanced distribution.

### Example:
For `n = 6` stores and `quantities = [11, 6]`:
- **Iteration 1**: `mid = 6`. Distribution possible with `x = 6`, so adjust `right = 6`.
- **Iteration 2**: `mid = 3`. Distribution possible with `x = 3`, so adjust `right = 3`.
- **Iteration 3**: `mid = 2`. Distribution not possible with `x = 2`, so adjust `left = 3`.
- **Result**: `left = 3`, the minimum `x` for feasible distribution.

This process efficiently finds the optimal `x` using binary search to minimize the maximum load per store.
*/ 
