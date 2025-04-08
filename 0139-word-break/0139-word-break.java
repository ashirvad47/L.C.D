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
        boolean[] tab = new boolean[s.length() + 1];
        tab[0] = true;

        for(int i = 1; i <= s.length(); i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(tab[j] && wordDict.contains(s.substring(j, i))) {
                    tab[i] = true;
                    break;
                }
            }
        }

        return tab[s.length()];
    }
}