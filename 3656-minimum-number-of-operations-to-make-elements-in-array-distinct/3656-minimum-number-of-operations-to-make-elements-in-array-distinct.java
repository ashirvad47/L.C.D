class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int firstRepeatIndex = -1;
        
        for(int i = nums.length-1; i >= 0; i--) {
            if(!set.add(nums[i])) {
                firstRepeatIndex = i;
                break;
            }
        }
        
        if(firstRepeatIndex == -1) return 0; 
        
        
        int elementsToRemove = firstRepeatIndex + 1;
        return (elementsToRemove + 2) / 3; 
    }
}