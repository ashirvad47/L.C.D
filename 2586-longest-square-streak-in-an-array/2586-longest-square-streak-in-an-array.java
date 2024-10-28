class Solution {
    public int longestSquareStreak(int[] nums) {
        HashSet<Long> uniqueNums = new HashSet<>();
        int maxStreak = 0;
        
        for (int i : nums) {
            uniqueNums.add((long)i);
        }
        
        for (int i : nums) {
            long num = i;
            int streak = 1;
            while (uniqueNums.contains(num * num)) {
                streak++;
                num = num * num;
            }
            maxStreak = Math.max(maxStreak, streak); 
        }
        
        return maxStreak >= 2 ? maxStreak : -1;
    }
}