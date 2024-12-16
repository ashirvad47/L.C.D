class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int i=0;i<k;i++){
            int index=findMinI(nums);
            nums[index]*=multiplier;
        }
        return nums;
    }
    public int findMinI(int[] arr ){
        int min =0;
        for(int i=1;i<arr.length;i++){
            if(arr[min]>arr[i])min=i;
        }
        return min;
    }
}