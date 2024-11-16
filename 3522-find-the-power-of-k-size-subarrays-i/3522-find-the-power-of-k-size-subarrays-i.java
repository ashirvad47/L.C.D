class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int res[] = new int [nums.length-k+1];

        int left=0;
        int right= left+k-1;

        while(left<nums.length-k+1){
            if(isSortedAndConsecutive(nums,left,right)){
                res[left] = nums[right];
            }else{
                res[left] =-1;
            }

            left++;
            right++;
        }
        return res;

    }

    public boolean isSortedAndConsecutive(int nums[],int left,int right){
        for(int i =left;i<right;i++){
            if(nums[i]>=nums[i+1] || nums[i]+1 != nums[i+1]) return false;
        }
        return true;
    }
}