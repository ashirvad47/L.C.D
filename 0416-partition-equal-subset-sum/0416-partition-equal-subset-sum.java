class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case: sum 0 is always possible
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >=  num)
                    dp[i][j] = dp[i][j] || dp[i - 1][j - num];
            }
        }

        return dp[n][target];
    }
}
