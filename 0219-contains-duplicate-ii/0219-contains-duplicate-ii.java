
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> indices = entry.getValue();
            for (int i = 0; i < indices.size()-1; i++) {
                if (Math.abs(indices.get(i) - indices.get(i + 1)) <= k) {
                    return true;
                }
            }
        }

        return false; 
    }
}
