class Solution {
    public int lengthAfterTransformations(String s, int t) {
        
        int[][] dp = new int[t + 1][26];

        for (int j = 0; j < 26; j++) dp[0][j] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 25) dp[i][j] = (dp[i - 1][0] + dp[i - 1][1]) % 1000000007;
                else  dp[i][j] = dp[i - 1][j + 1];
            }
        }
        long total = 0;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            total = (total + dp[t][idx]) % 1000000007;
        }
        return (int) total;
    }
}