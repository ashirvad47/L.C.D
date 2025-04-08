class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return helper(s,wordDict,0,memo);
    }

    private boolean helper(String s, List<String> wordDict, int idx, Boolean memo[]) {
        if (idx == s.length())
            return true;
        if (memo[idx] != null)
            return memo[idx];

        boolean found = false;
        for(int i =idx;i <= s.length();i++){
            String pref = s.substring(idx,i);

            if(wordDict.contains(pref)){
                if(helper(s,wordDict,i,memo)) {
                    found=true;
                    break;
                }
            }
        }

        memo[idx] =found;
        return found;

    }
}