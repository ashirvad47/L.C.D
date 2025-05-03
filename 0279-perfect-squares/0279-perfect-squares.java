class Solution {
    public int numSquares(int n) {
        int [] sqr = new int[(int)Math.floor(Math.sqrt(n))+1];

        for(int i=0;i<sqr.length;i++) sqr[i]=(int)Math.pow(i+1,2);

        int dp [][]= new int [sqr.length+1][n+1];

        for(int i =1;  i < dp[0].length;i++) dp[0][i] = Integer.MAX_VALUE-1;

        for(int i =1; i< dp.length;i++)
            for(int j =1; j < dp[0].length; j++){
                if(sqr[i-1]<= j) dp[i][j] = Math.min(1+ dp[i][j-sqr[i-1]], dp[i-1][j]);
                else dp[i][j]=  dp[i-1][j];
            }

        return dp[sqr.length][n] == Integer.MAX_VALUE -1? -1 : dp[sqr.length][n] ;
    }
}