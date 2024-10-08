class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[]= new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i =0; i < nums.length;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                result[0]= map.get(complement);
                result[1]= i;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return result;
    }
}
