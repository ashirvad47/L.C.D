// // TWO POINTERS

// class Solution {
//     public boolean isSubsequence(String s, String t) {
//         int i=0,j=0;
//         while(i<s.length() && j <t.length()){
//             if(s.charAt(i)==t.charAt(j)){
//                 i++;
//             }
//             j++;
//         }
        
//         return i==s.length();
//     }
// }

// DYNAMIC PROGRAMMING(SIMILAR TO LCS)

class Solution {
    public boolean isSubsequence(String s, String t) {
        int dp[][] = new int [s.length()+1][t.length()+1];

        for(int i =1; i < dp.length;i++)
            for(int j =1;j <dp[0].length;j++){
                if(s.charAt(i-1)==t.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        // System.out.println(dp[s.length()][t.length()]);
        return s.length() == dp[s.length()][t.length()];
    }
}