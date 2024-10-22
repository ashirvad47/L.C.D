class Solution {
    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();
        return backtrack(s, 0, set);
    }
    
    private int backtrack(String s, int start, HashSet<String> set) {
        if (start == s.length()) {
            return 0;
        }
        
        int maxSplits = 0;
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (!set.contains(substring)) {
                set.add(substring);
                maxSplits = Math.max(maxSplits, 1 + backtrack(s, end, set));
                set.remove(substring);
            }
        }
        
        return maxSplits;
    }
}
