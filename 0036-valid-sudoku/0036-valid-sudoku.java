class Solution {
    public boolean isValidSudoku(char[][] board) {
        // HashSet<Char> row = new HashSet<>();
        // HashSet<Char> column = new HashSet<>();
        // HashSet<Char> mini = new HashSet<>();

        for(int i =0; i < 9;i++){
            HashSet<Character> row = new HashSet<>();
            for(int j=0; j<9;j++){
                if(!row.contains(board[i][j]) || board[i][j]=='.'){
                    row.add(board[i][j]);
                }
                else{
                    return false;
                }
            }
        }
        for(int i =0; i < 9;i++){
            HashSet<Character> column = new HashSet<>();
            for(int j=0; j<9;j++){
                if(!column.contains(board[j][i]) || board[j][i]=='.'){
                    column.add(board[j][i]);
                }
                else{
                    return false;
                }
            }
        }

        HashSet<Character>[] mini = new HashSet[9];

        for(int i=0;i<9;i++){
            mini[i]= new HashSet<>();
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                
                int miniIndex= (i/3)*3 + (j/3);

                if(!mini[miniIndex].contains(board[i][j]) || board[i][j]=='.'){
                    mini[miniIndex].add(board[i][j]);
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}