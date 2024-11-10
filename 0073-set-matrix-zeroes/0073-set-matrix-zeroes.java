class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] colZero = new boolean[matrix[0].length];
        boolean[] rowZero = new boolean[matrix.length];

        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    colZero[j] = true;
                    rowZero[i] = true;
                }
            }
        }

        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (colZero[j] == true || rowZero[i] == true) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
