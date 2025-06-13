class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length-1] - nums[0];

        while(left < right){
            int mid = left + (right - left)/2;
            if(countPairs(nums, mid) < p){
                left = mid+1;
            } else{
                right = mid;
            }
        }

        return left;
    }
    private int countPairs(int[] nums, int interval){
        int idx = 0, count = 0;

        while(idx < nums.length-1){
            if(nums[idx+1] - nums[idx] <= interval){
                idx++;
                count++;
            }
            idx++;
        }

        return count;
    }
}