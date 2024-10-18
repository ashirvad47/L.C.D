class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        HashSet<List<Integer>> hs = new HashSet<>();
        for(int i =0; i<nums.length-2;i++){
            HashMap<Integer,Integer> map = new HashMap <>();
            for(int j=i+1;j<nums.length;j++){
                int complement= -nums[i]-nums[j];
                if (map.containsKey(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                    Collections.sort(triplet);
                    hs.add(triplet);
                }
                else{
                    map.put(nums[j],j);
                }
            }
        }
        return new ArrayList<>(hs);
    }
}