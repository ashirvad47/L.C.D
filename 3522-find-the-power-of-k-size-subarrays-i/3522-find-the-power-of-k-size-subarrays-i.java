class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length - k + 1; // Precompute length of result array
        int[] res = new int[n];

        for (int left = 0; left < n; left++) {
            if (isSortedAndConsecutive(nums, left, left + k - 1)) {
                res[left] = nums[left + k - 1]; // Use `right = left + k - 1`
            } else {
                res[left] = -1;
            }
        }
        return res;
    }

    public boolean isSortedAndConsecutive(int[] nums, int left, int right) {
        for (int i = left; i < right; i++) {
            if (nums[i] + 1 != nums[i + 1]) { // Check consecutive
                return false;
            }
        }
        return true; // All elements are sorted and consecutive
    }
}
