class Solution {
    // Define direction arrays for all 4 directions (up, right, down, left)
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        
        // Instead of a HashMap, we use an array to store region areas.
        // Maximum possible region id is at most n*n (each cell isolated) plus the starting offset (2)
        int[] regionSize = new int[n * n + 2];
        int region = 2;
        
        // First pass: Label each island with a unique region number and compute its area.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // Use DFS to compute area and label the region.
                    regionSize[region] = dfs(grid, i, j, region);
                    region++;
                }
            }
        }
        
        // If the entire grid is land, regionSize[2] holds the area of the only island.
        int max = 0;
        for (int size : regionSize) {
            max = Math.max(max, size);
        }
        
        // Second pass: Try to flip each 0 and calculate maximum possible island.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int area = 1;  // Start with 1 for the cell we're flipping
                    // Use a boolean array to mark which regions have been added
                    // (Alternatively, you can use a small HashSet if you prefer.)
                    boolean[] used = new boolean[region];
                    
                    // Check all 4 directions.
                    for (int d = 0; d < 4; d++) {
                        int newRow = i + dx[d];
                        int newCol = j + dy[d];
                        
                        // Only process if neighbor is within bounds.
                        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                            int neighborRegion = grid[newRow][newCol];
                            // Only add if it is part of an island (region id > 1)
                            // and if we haven't already added this island.
                            if (neighborRegion > 1 && !used[neighborRegion]) {
                                area += regionSize[neighborRegion];
                                used[neighborRegion] = true;
                            }
                        }
                    }
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }
    
    // DFS method to label the island and calculate its area.
    private int dfs(int[][] grid, int i, int j, int region) {
        int n = grid.length;
        // Return 0 if out-of-bounds or not a land cell (1).
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        
        // Mark the cell with the region id.
        grid[i][j] = region;
        int area = 1;
        
        // Recursively explore all 4 directions.
        for (int d = 0; d < 4; d++) {
            area += dfs(grid, i + dx[d], j + dy[d], region);
        }
        return area;
    }
}
