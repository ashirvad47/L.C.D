class Solution{
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int maxi = 1;
        for(int num : nums){
            int currNum = num % k;
            for (int mod = 0; mod < k; mod++) {
                int prevNum = (mod - currNum + k) % k;
                dp[currNum][mod] = Math.max(dp[currNum][mod] , 1 + dp[prevNum][mod]);
                maxi = Math.max(maxi , dp[currNum][mod]);
            }
        }
        return maxi;
    }
}