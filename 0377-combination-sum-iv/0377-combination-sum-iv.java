class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int i = 1; i <= target; i++) {

            for (int num : nums) {
                if (num<= i) {
                    dp[i]+= dp[i- num];
                }
            }
        }

        return dp[target];
    }
}

// For each target sum i, iterate through the numbers in nums.
// If the current sum i is greater than or equal to the number num,
// it means we can potentially form sum i by adding num to a
// previous sum (i - num).
// The final answer is the number of ways to make the target sum.