class Solution {
    public int numTilings(int n) {
    int MOD = 1000000007;
    long[][] dp = new long[n + 1][3];

    dp[0][0] = 1; 
    dp[0][1] = 0;
    dp[0][2] = 0;

    for (int i = 1; i <= n; i++) {
        dp[i][0] = dp[i - 1][0];
        if (i >= 2) dp[i][0] = (dp[i][0] + dp[i - 2][0]) % MOD;
        dp[i][0] = (dp[i][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;

        if (i >= 2)
            dp[i][1] = (dp[i - 2][0] + dp[i - 1][2]) % MOD;
        else
            dp[i][1] = 0;

        if (i >= 2)
            dp[i][2] = (dp[i - 2][0] + dp[i - 1][1]) % MOD;
        else
            dp[i][2] = 0;
    }

    return (int) dp[n][0]; 
}

}