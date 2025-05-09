class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n=word2.length();

        int dp[][] = new int [m+1][n+1];

        for(int i =0; i < dp.length;i++) dp[i][0] =i;
        for(int j =0; j < dp[0].length;j++) dp[0][j]= j;

        for(int i =1; i< dp.length;i++)
            for(int j=1;j < dp[0].length;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j] =  dp[i-1][j-1];
                else dp[i][j]= 1 +  Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
            }

        return dp[m][n];

    }
}

/*
This code calculates the minimum number of operations required to convert word1 into word2 using Dynamic Programming.
It implements the classic Edit Distance (Levenshtein Distance) algorithm, which allows three operations: insert, delete, and replace.

We define dp[i][j] as the minimum number of edits needed to convert the first i characters of word1 to the first j characters of word2.
- Base cases:
  - dp[0][j] = j (it takes j insertions to convert an empty string to word2's first j chars)
  - dp[i][0] = i (it takes i deletions to convert word1's first i chars to an empty string)
  
- For each character comparison:
  - If word1[i-1] == word2[j-1], no edit is needed: dp[i][j] = dp[i-1][j-1]
  - Else, we consider the minimum among:
    - dp[i-1][j] (delete word1's char),
    - dp[i][j-1] (insert word2's char),
    - dp[i-1][j-1] (replace word1's char),
    and add 1 operation cost.

Finally, dp[m][n] gives the answer, where m and n are the lengths of word1 and word2.
Time Complexity: O(m * n), Space Complexity: O(m * n)
*/
