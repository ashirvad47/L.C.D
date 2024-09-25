class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length / 2;

        HashMap<Integer, Integer> set = new HashMap<>();

        for (int i : nums) {
            set.put(i, set.getOrDefault(i, 0) + 1);
        }

        for (int key : set.keySet()) {
            if (set.get(key) > n) {
                return key;
            }
        }
        return -1;
    }
}