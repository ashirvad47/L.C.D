class Solution {
    public boolean canJump(int[] nums) {
        int maxReachableIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReachableIndex) {
                return false;
            }

            maxReachableIndex = Math.max(maxReachableIndex, i + nums[i]);
        }

        return true;
    }
}