class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1_000_000_007;
        int n = nums.length;

        Arrays.sort(nums);

        int[] pow2 = new int[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % mod;
        }

        long ans = 0;
        int left = 0, right = n - 1;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                ans = (ans + pow2[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }

        return (int) ans;
    }
}


// ### Explanation

// 1. **Sorting**  
//    We sort `nums` so that for any chosen subsequence the smallest element is at index `left` and the largest at index `right`.  

// 2. **Precompute Powers of Two**  
//    We build an array `pow2` where  
//    \[
//      \text{pow2}[i] = (2^i) \bmod (10^9+7).
//    \]
//    This lets us quickly count how many ways there are to include or exclude intermediate elements.

// 3. **Two-Pointer Sweep**  
//    - Initialize `left = 0`, `right = n - 1`.  
//    - While `left ≤ right`:
//      - If `nums[left] + nums[right] ≤ target`, then **every** subsequence that includes both `nums[left]` and `nums[right]` — and any subset of the elements in between — is valid. There are \(2^{\,\text{right}-\text{left}}\) such subsets, so we add `pow2[right - left]` to the answer and move `left++` to try the next minimum.
//      - Otherwise, the current pair is too large, so we move `right--` to try a smaller maximum.

// 4. **Modulo**  
//    We take all additions modulo \(10^9 + 7\) to keep numbers within 32-bit range.

// ---

// ### Dry Run on Example

// Let `nums = [3, 5, 6, 7]`, `target = 9`.

// 1. **Sort** → `[3, 5, 6, 7]`  
// 2. **Precompute** powers (just the first few):
//    ```
//    pow2 = [1, 2, 4, 8, 16]
//    ```
// 3. **Initialize** `left = 0`, `right = 3`, `ans = 0`.

// 4. **Iteration 1**  
//    - `nums[0] + nums[3] = 3 + 7 = 10` > 9  
//    - Too big → `right = 2`

// 5. **Iteration 2**  
//    - `nums[0] + nums[2] = 3 + 6 = 9` ≤ 9  
//    - Add `pow2[2 - 0] = pow2[2] = 4` → `ans = 4`  
//    - Move `left = 1`

// 6. **Iteration 3**  
//    - `nums[1] + nums[2] = 5 + 6 = 11` > 9  
//    - Too big → `right = 1`

// 7. **Iteration 4**  
//    - `left = 1`, `right = 1`  
//    - `nums[1] + nums[1] = 5 + 5 = 10` > 9  
//    - Too big → `right = 0`

// 8. **Loop Ends** (`left = 1`, `right = 0`, so `left > right`)

// Final answer = 4, matching the four valid subsequences:
// ```
// [3], [3,5], [3,6], [3,5,6]
// ```

// ---

// This approach runs in \(O(n\log n)\) time (for the sort) plus \(O(n)\) for the two-pointer scan, and uses \(O(n)\) extra space for the power table.