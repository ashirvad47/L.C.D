class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int lastInvalid = -1;
        int lastMinK = -1;
        int lastMaxK = -1;
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                lastInvalid = i;
                lastMinK = -1;
                lastMaxK = -1;
            } else {
                if (nums[i] == minK) lastMinK = i;
                if (nums[i] == maxK) lastMaxK = i;

                if (lastMinK != -1 && lastMaxK != -1) {
                    count += Math.max(0, Math.min(lastMinK, lastMaxK) - lastInvalid);
                }
            }
        }

        return count;
    }
}
