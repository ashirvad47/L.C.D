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
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];

        queue.offer(0);

        while (!queue.isEmpty()) {
            int start = queue.poll();

            if (visited[start]) continue;

            for (int end = start + 1; end <= s.length(); end++) {
                if (dict.contains(s.substring(start, end))) {
                    if (end == s.length()) return true;
                    queue.offer(end);
                }
            }

            visited[start] = true;
        }

        return false;
    }
}
