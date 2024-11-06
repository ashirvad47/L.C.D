class Solution {
    public boolean canSortArray(int[] nums) {
        int prevGroupMax=0;
        int currMax= nums[0];

        for(int i=1;i<nums.length;i++){
            if(Integer.bitCount(nums[i-1])!=Integer.bitCount(nums[i])){
                prevGroupMax = currMax;
            }

            currMax = Math.max(currMax,nums[i]);

           if (prevGroupMax>nums[i]) {
                return false;
            } 
        }
        return true;
    }
}