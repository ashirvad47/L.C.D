class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        
        // Step 1: Compute prefix sums for both rows
        long[] topPrefix = new long[n];
        long[] bottomPrefix = new long[n];
        
        topPrefix[0] = grid[0][0];
        bottomPrefix[0] = grid[1][0];
        
        for (int i = 1; i < n; i++) {
            topPrefix[i] = topPrefix[i - 1] + grid[0][i];
            bottomPrefix[i] = bottomPrefix[i - 1] + grid[1][i];
        }
        
        // Step 2: Find the minimum maximum points the second robot can collect
        long minSecondRobotPoints = Long.MAX_VALUE;
        
        for (int c = 0; c < n; c++) {
            // Points above the split
            long topPoints = (c == n - 1) ? 0 : topPrefix[n - 1] - topPrefix[c];
            
            // Points below the split
            long bottomPoints = (c == 0) ? 0 : bottomPrefix[c - 1];
            
            // Max points the second robot collects at this split
            long secondRobotPoints = Math.max(topPoints, bottomPoints);
            
            // Minimize the max points collected by the second robot
            minSecondRobotPoints = Math.min(minSecondRobotPoints, secondRobotPoints);
        }
        
        return minSecondRobotPoints;
    }
}
