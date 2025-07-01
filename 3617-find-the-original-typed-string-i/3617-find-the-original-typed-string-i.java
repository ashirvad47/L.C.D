class Solution {
    public int possibleStringCount(String word) {
        if (word.length() <= 1) return 1;
        
        int result = 1;
        
        for (int i = 0; i < word.length(); i++) {
            int consecutiveCount = 1;
            while (i + 1 < word.length() && word.charAt(i) == word.charAt(i + 1)) {
                consecutiveCount++;
                i++;
            }
            if (consecutiveCount >= 2) {
                result++;
                if (consecutiveCount > 2) {
                    result += (consecutiveCount - 2);
                }
            }
        }
        
        return result;
    }
}