class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        int[] rowDir = { -1, -1, -1, 0, 1, 1, 1, 0 };
        int[] colDir = { -1, 0, 1, 1, 1, 0, -1, -1 };

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int liveNeighbors = 0;

                for (int k = 0; k < 8; k++) {
                    int newRow = i + rowDir[k];
                    int newCol = j + colDir[k];

                    if (newRow >= 0 && newRow < row && 
                        newCol >= 0 && newCol < col &&
                        (board[newRow][newCol] % 2 == 1)) {
                        liveNeighbors++;
                    }
                    if(liveNeighbors >=4) break;
                }

                if (board[i][j] == 1 && (liveNeighbors == 2 || liveNeighbors == 3)) {
                    board[i][j] += 2; 
                } else if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] += 2;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] /= 2; 
            }
        }
    }
}
