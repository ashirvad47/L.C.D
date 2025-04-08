//TOP TO BOTTOM (MEMOIZATION)

// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Boolean []memo = new Boolean[s.length()];

//         return wordBreak(s,wordDict,0,memo);
//     }

//     private boolean wordBreak(String s, List<String> wordDict, int idx, Boolean [] memo){
//             if(idx==s.length()) return true;

//             if(memo[idx]!=null) return memo[idx];

//             boolean found;
//             for(int i = idx+1; i<= s.length();i++){
//                 String sub = s.substring(idx,i);

//                 if(wordDict.contains(sub)) if(wordBreak(s,wordDict,i , memo)) {
//                     found = true;
//                     return found;
//                 }
//             }


            
//             return memo[idx] = false;
//     }
// }

//BOTTOM TO TOP (TABULATION)

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // empty string

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
