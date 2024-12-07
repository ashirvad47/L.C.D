class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1, high = getMax(nums);
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canAchievePenalty(nums, mid, maxOperations)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int getMax(int[] nums) {
        // int max = Integer.MIN_VALUE;
        // for (int num : nums) {
        //     max = Math.max(max, num);
        // }
        // return max;
        Arrays.sort(nums);
        return nums[nums.length-1];
    }

    private boolean canAchievePenalty(int[] nums, int penalty, int maxOperations) {
        int operations = 0;
        for (int num : nums) {
            operations += (num - 1) / penalty;
            if (operations > maxOperations) return false;
        }
        return true;
    }
}
