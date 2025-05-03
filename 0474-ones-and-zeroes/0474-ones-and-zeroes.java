class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int zeros [] = new int [strs.length];
        int ones [] = new int [strs.length];

        int ind=0;
        for(String i : strs){
            char ch[] = i.toCharArray();
            for(char c : ch){
                if(c=='0') zeros[ind]++;
                else ones[ind]++;
            }
            ind++;
        }

        int dp[][][] = new int [strs.length+1][m+1][n+1];

        for(int i =1; i < dp.length;i++){
            int z = zeros[i-1];
            int o = ones[i-1];
            for(int j =0 ; j < dp[0].length; j++)
                for(int k=0; k < dp[0][0].length;k++){
                    if (j >= z && k >= o) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k],
                                            dp[i-1][j-z][k-o]+1);
                    }
                    else dp[i][j][k]=  dp[i-1][j][k];
                }
        }

        return dp [strs.length][m][n];



    }
}