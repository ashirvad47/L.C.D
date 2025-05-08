class Solution {
    public int minInsertions(String s) {
        String revS = (new StringBuilder(s)).reverse().toString();

        int dp[][] = new int [s.length()+1][revS.length()+1];

        for(int i =1; i < dp.length;i++)
            for(int j =1; j < dp.length; j++){
                if(s.charAt(i-1)==revS.charAt(j-1)) dp[i][j]= 1+ dp[i-1][j-1];
                else dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
            }

        return s.length()-dp[s.length()][s.length()];
    }
}