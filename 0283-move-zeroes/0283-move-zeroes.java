class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length==1) return;

        int count =0; 
        for(int i : nums) if(i==0) count++;

        if(count==0) return;

        int idx=0;

        for(int i=0; i< nums.length;i++){
            if(nums[i]!=0) {
                nums[idx]=nums[i];
                idx++;
            }
        }
        for(int i=nums.length-count; i<nums.length;i++) nums[i]=0;


    }
}