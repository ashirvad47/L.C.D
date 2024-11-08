class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        generateSubsets(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void generateSubsets(List<List<Integer>> list, List<Integer> tempList, int[] nums, int idx) {
       
        if (idx == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        generateSubsets(list, tempList, nums, idx + 1);

        tempList.add(nums[idx]);
        generateSubsets(list, tempList, nums, idx + 1);
        tempList.remove(tempList.size() - 1);
    }
}
