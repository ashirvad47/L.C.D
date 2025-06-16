class Solution {
    public int maximumDifference(int[] nums) {
        int diff= nums[0];
        int maxdiff=-1;

        for (int i =0; i <nums.length; i++){
            if(nums[i]> diff){
                maxdiff = Math.max(maxdiff, nums[i]-diff);
            }else{
                diff= nums[i];
            }
    }
    return maxdiff;
    }
}