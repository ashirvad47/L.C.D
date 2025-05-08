class Solution {
    public String longestPalindrome(String s) {
        String revS = (new StringBuilder(s)).reverse().toString();
        int n = s.length();

        int dp[][] = new int [n+1][n+1];
        int maxLen = 0;
        int endIndex = 0; 

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == revS.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    int revIndexInOriginal = n - j;
                    if (revIndexInOriginal + dp[i][j] - 1 == i - 1) {
                        if (dp[i][j] > maxLen) {
                            maxLen = dp[i][j];
                            endIndex = i - 1;
                        }
                    }

                } 
            }
        }

        return s.substring(endIndex - maxLen + 1, endIndex + 1);
    }
}
