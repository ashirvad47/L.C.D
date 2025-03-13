// class Solution {
//     public int uniquePaths(int m, int n) {
//         return helper(0,0,m,n);
//     }

//     public int helper(int x, int y, int m, int n ){
//         if(x>=m || y>=n) return 0;
//         if(x==m-1 && y ==n-1) return 1;

//         return helper(x+1,y,m,n) +helper(x,y+1,m,n);
//     }
// }


class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // Initialize the first row and first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        // Fill the dp table using the transition formula
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        // The answer is in the bottom-right cell
        return dp[m-1][n-1];
    }
}
