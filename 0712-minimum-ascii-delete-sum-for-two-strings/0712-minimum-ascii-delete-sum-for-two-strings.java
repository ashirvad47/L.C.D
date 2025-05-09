class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();

        int dp[][] = new int[m + 1][n + 1];

        for (int i = 1; i < dp.length; i++)
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

            }

        // int i = m, j = n;
        // // String s ="";
        // int sumS = 0;
        // while (i > 0 && j > 0) {
        //     if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
        //         // s= s1.charAt(i-1) +s;
        //         sumS += s1.charAt(i - 1);
        //         i--;
        //         j--;
        //     } else if (dp[i - 1][j] > dp[i][j - 1])
        //         i--;
        //     else
        //         j--;
        // }

        int sumS1 = 0, sumS2 = 0;

        for (char c : s1.toCharArray())
            sumS1 += c;
        for (char c : s2.toCharArray())
            sumS2 += c;

        return sumS1 + sumS2 - 2 * dp[m][n];

    }
}