class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2 * nums.length];
        System.arraycopy(nums, 0, ans, 0, nums.length);
        System.arraycopy(nums, 0, ans, nums.length, nums.length);
        return ans;

        // for(int i=0;i<2 * nums.length;i++){
        //     ans[i]=nums[i%nums.length];
        // }
        // return ans;
    }
}
