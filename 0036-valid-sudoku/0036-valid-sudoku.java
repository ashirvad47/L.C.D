class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check each row
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current != '.') {
                    if (!row.add(current)) {  // If add returns false, it means duplicate exists
                        return false;
                    }
                }
            }
        }

        // Check each column
        for (int i = 0; i < 9; i++) {
            HashSet<Character> column = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char current = board[j][i];
                if (current != '.') {
                    if (!column.add(current)) {  // If add returns false, duplicate exists
                        return false;
                    }
                }
            }
        }

        // Check each 3x3 sub-grid
        HashSet<Character>[] mini = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            mini[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current != '.') {
                    int miniIndex = (i / 3) * 3 + (j / 3);
                    if (!mini[miniIndex].add(current)) {  // If add returns false, duplicate exists
                        return false;
                    }
                }
            }
        }

        // If no duplicates are found, the board is valid
        return true;
    }
}
