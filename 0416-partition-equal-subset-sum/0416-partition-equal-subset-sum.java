class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        int n = nums.length;

        boolean[] dp = new boolean[target + 1];

        // Base case: sum 0 is always possible
        dp[0] = true;

        // Fill the dp table
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}


//SEE ALL 3 APPROACHES FOR REVISION