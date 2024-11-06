class Solution {
    public boolean canSortArray(int[] nums) {
        int prevGroupMax=0;
        int currMax= nums[0];

        for(int i=0;i<nums.length-1;i++){
            if(Integer.bitCount(nums[i])!=Integer.bitCount(nums[i+1])){
                prevGroupMax = currMax;
            }

            currMax = Math.max(currMax,nums[i+1]);

           if (prevGroupMax>nums[i+1]) {
                return false;
            } 
        }
        return true;
    }
}