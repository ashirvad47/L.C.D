// class Solution {
//     public int minSubArrayLen(int target, int[] nums) {

//         int sum = 0;
//         int len = Integer.MAX_VALUE;
//         for (int i = 0, j = 0; i < nums.length; i++) {
//             sum += nums[i];
//             if (sum >= target) {
//                 len = Math.min(len, i - j + 1);
//                 j += 1;
//                 i = j - 1;
//                 sum = 0;
//             }
//         }
//         return len < Integer.MAX_VALUE ? len : 0;
//     }
// }

// better sol below

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0,j=0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) {
                minLength = Math.min(minLength, i - j + 1);
                sum -= nums[j];
                j++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}