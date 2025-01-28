class Solution {
    int maxFish = 0;
    
    public int findMaxFish(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != 0) {
                    int currentFish = dfs(grid, i, j);
                    maxFish = Math.max(maxFish, currentFish);
                }
            }
        }
        return maxFish;
    }

    private int dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        
        int currentFish = grid[i][j];
        grid[i][j] = 0;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for(int z = 0; z < 4; z++) {
            int newI = i + dx[z];
            int newJ = j + dy[z];
            currentFish += dfs(grid, newI, newJ);
        }
        
        return currentFish;
    }
}