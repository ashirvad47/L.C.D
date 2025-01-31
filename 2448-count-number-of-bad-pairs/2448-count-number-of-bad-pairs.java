class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] -= i;
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        long totalPairs = (long) n * (n - 1) / 2;
        long goodPairs = 0;

        for (int count : map.values()) {
            goodPairs += (long) count * (count - 1) / 2;
        }

        return totalPairs - goodPairs;
    }
}
