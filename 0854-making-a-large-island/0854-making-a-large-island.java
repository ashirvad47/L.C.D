class Solution {
    // Define direction arrays for all 4 directions (up, right, down, left)
    private final int[] dx = {-1, 0, 1, 0};  // Changes in row
    private final int[] dy = {0, 1, 0, -1};  // Changes in column
    
    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> regionsArea = new HashMap<>();
        regionsArea.put(0, 0);
        int n = grid.length;
        int region = 2;
        
        // First pass: Label each island with a unique region number
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    int area = floodFill(grid, i, j, region);
                    regionsArea.put(region, area);
                    region++;
                }
            }
        }
        
        // Handle case where grid is all 1s
        int max = regionsArea.getOrDefault(2, 0);
        
        // Second pass: Try to flip each 0 and calculate maximum possible island
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == 0) {
                    Set<Integer> neighbors = new HashSet<>();
                    // Use direction arrays to check all 4 neighbors
                    for(int i = 0; i < 4; i++) {
                        int newRow = r + dx[i];
                        int newCol = c + dy[i];
                        if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                            neighbors.add(grid[newRow][newCol]);
                        } else {
                            neighbors.add(0);  // Add 0 for out-of-bounds cells
                        }
                    }
                    
                    int area = 1;  // Start with 1 for the cell we're flipping
                    for(int neighbor: neighbors) {
                        area += regionsArea.get(neighbor);
                    }
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }
    
    public int floodFill(int[][] grid, int r, int c, int region) {
        int n = grid.length;
        if(r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != 1) {
            return 0;
        }
        
        grid[r][c] = region;
        int sum = 1;
        
        // Use direction arrays for the flood fill
        for(int i = 0; i < 4; i++) {
            sum += floodFill(grid, r + dx[i], c + dy[i], region);
        }
        
        return sum;
    }
}