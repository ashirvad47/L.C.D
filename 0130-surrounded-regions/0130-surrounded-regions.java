class Solution {
    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // identifying border 'O's since they can be protected only

        //top row
        for (int i = 0; i < n; i++) {
            if (board[0][i]=='O') dfs(board,0,i) ;
        }

        //right column 
        for (int i = 1; i < m - 1; i++) {
            if(board[i][n - 1] =='O') dfs(board,i,n-1) ;
        }

        //bottom row 
        for (int i = 0; i < n; i++) {
            if(board[m - 1][i]=='O') dfs(board,m-1,i) ;
        }

        //left column 
        for (int i = 1;  i<m-1 ; i++) {
            if(board[i][0] =='O') dfs(board,i,0) ;
        }

        for(int i =0; i< m;i++){
            for(int j =0;j <n;j++){
                if(board[i][j]=='O')board[i][j]='X';
                else if(board[i][j]=='S')board[i][j]='O';
            }
        }
    }

    // if there is 'O's in border, turn them into 'S' to mark safe zones
    private void dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;

        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };

        board[i][j] = 'S';

        for (int z = 0; z < 4; z++) {
            int row = i + dx[z];
            int col = j + dy[z];

            if (row >= 0 && row < m && col >= 0 && col < n && board[row][col] == 'O') {
                dfs(board, row, col);
            }
        }

    }
}