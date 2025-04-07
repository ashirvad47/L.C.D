class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;

       Boolean[][] memo = new Boolean[nums.length][target + 1];

        return helper(nums, 0, target, 0, memo);
    }

    private boolean helper(int[] nums, int idx, int target, int currSum, Boolean[][] memo) {
        if (currSum == target)
            return true;
        if (idx >= nums.length)
            return false;

        if (memo[idx][currSum] != null)
            return memo[idx][currSum];

        boolean found = false;
        for (int i = idx; i < nums.length; i++) {
            if (currSum + nums[i] <= target) {
                if (helper(nums, i + 1, target, currSum + nums[i], memo)) {
                    found = true;
                    break;
                }
            }
        }

        memo[idx][currSum] = found;
        return found;
    }
}
