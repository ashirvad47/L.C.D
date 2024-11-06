class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allCases = new ArrayList<>();
        char[][] board = new char[n][n];

        helper(allCases, board, 0);

        return allCases;
    }

    public void helper(List<List<String>> allBoards, char[][] board, int col) {
        if (col == board.length) {
            saveBoard(allBoards, board);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                helper(allBoards, board, col + 1);
                board[row][col] = '.';
            }

        }
    }

    public boolean isSafe(int row, int col, char[][] board) {
        // Check left side of the row
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q')
                return false;
        }

        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // Check lower-left diagonal
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // No need to check other diagonals on right side or vertically

        return true;
    }

    public void saveBoard(List<List<String>> allBoards, char[][] board) {
        List<String> newBoard = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                row.append(board[i][j] == 'Q' ? 'Q' : '.');
            }
            newBoard.add(row.toString());
        }
        allBoards.add(newBoard);
    }

}