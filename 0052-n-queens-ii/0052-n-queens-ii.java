class Solution {
    int  count=0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        
        helper(board,0);
        return count;
    }

    public void helper(char[][]board, int col){

        if(col==board.length){
            count++;
            return;
        }
        for(int row  =0;row <board.length;row++){
            if(isSafe(row,col,board)){
                board[row][col] ='Q';
                helper(board,col+1);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(int row,int col, char[][]board){
        for(int i=0;i < col;i++){
            if(board[row][i]=='Q'){
                return false;
            }
        }
        for(int i =row,j = col; i>=0 && j >=0;i--,j-- ){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i =row,j = col; i < board.length && j >=0;i++,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }



}