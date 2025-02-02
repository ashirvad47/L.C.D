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

    public void helper(char[][] grid, int reg, int row , int col){

        int m = grid.length;
        int n = grid[0].length;

        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != '1') {
            return;
        }

        int []  dx={-1,1,0,0};
        int []  dy={0,0,1,-1};

        grid[row][col]= (char) (reg+'0');

        for(int z =0; z < 4; z++){
            helper(grid, reg, row + dx[z], col + dy[z]);
        }


    }
}