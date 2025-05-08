class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        int count = 0;

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) &&
                    (len < 3 || dp[i+1][j-1] == 1)) {
                    dp[i][j] = 1;
                    count++;
                }
            }
        }

        return count;
    }
}
