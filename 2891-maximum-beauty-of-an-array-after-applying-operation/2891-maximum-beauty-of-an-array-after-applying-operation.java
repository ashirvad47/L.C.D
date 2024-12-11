class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int left=0;

        int max=0;

        for(int right=0; right<nums.length;right++){
            while(nums[right]-nums[left] >2*k) left++;

            int temp = right-left+1;

            max= Math.max(temp,max);
        }

        return max;
    }
}