class Solution {
    public int[] buildArray(int[] nums) {
        int []ans = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}

//O(1) space below

// class Solution {
//     public int[] buildArray(int[] nums) {
//         int n =nums.length;
//         for(int i =0;i<n;i++){
//            nums[i]=nums[i] + n*(nums[nums[i]]%n);
//         }
//         for(int i =0; i <n;i++){
//             nums[i]=nums[i]/n;
//         }
//         return nums;
//     }
// }