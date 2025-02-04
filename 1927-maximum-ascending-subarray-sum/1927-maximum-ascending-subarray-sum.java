class Solution {
    public int maxAscendingSum(int[] nums) {
        int x = nums[0];
        int maxSum = nums[0];
        for(int i=1; i <nums.length;i++){
            if(nums[i]>nums[i-1]){
                x += nums[i];
            }else{
                x=nums[i];
            }
            maxSum = Math.max(maxSum,x);

        }
        return maxSum;
    }
}