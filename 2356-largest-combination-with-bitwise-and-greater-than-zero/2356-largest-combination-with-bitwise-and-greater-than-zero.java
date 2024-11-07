class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitCount = new int[31];  
        
        for (int num : candidates) {
            for (int i = 0; i < 31; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }
        
        int maxCount = 0;
        for (int count : bitCount) {
            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
    }
}