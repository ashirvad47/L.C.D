class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j]!= '.') {
                    if (!row.add(board[i][j])) {  
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            HashSet<Character> column = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (!column.add(board[j][i])) { 
                        return false;
                    }
                }
            }
        }
        HashSet<Character>[] mini = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            mini[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int miniIndex = (i / 3) * 3 + (j / 3);
                    if (!mini[miniIndex].add(board[i][j])) { 
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
