class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ls = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            int end = start;

            while (i < nums.length - 1 && nums[i] == nums[i + 1] - 1) {
                i++;
                end = nums[i];
            }

            ls.add(start == end ? ""+start : start + "->" + end);

        }

        return ls;
    }
}
