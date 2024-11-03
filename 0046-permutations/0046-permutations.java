class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), nums);
        return result;
    }

    static void backTrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {

        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i]) == false) {
                tempList.add(nums[i]);
                backTrack(result, tempList, nums);
                tempList.remove(tempList.size() - 1);

            }
        }
        return;
    }
}