class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int reg = 2;

        for(int i =0 ; i < m ; i ++){
            for ( int j  =0; j < n ;j++){
                if(grid[i][j]=='1') {
                    helper(grid, reg,i,j);
                    reg++;
                }
                
            }
        }

        return reg-2;

    }

    public void helper(char[][] grid, int reg, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        grid[i][j] = (char)(reg + '0');
        
        for(int z = 0; z < 4; z++) {
            int row = i + dx[z];
            int col = j + dy[z];
            
            if(row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == '1') {
                helper(grid, reg, row, col);
            }
        }
    }
}