class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int len1 = mat.length;
        int len2 = mat[0].length;
        int len = len1 * len2;

        int[] ans = new int[len];
        int row = 0, col = 0;
        for (int i = 0; i < len; i++) {
            ans[i] = mat[row][col];
            if ((row + col) % 2 == 0) {
                if (col == len2 - 1) {
                    row++;
                } else if (row == 0) {
                    col++;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == len1 - 1) {
                    col++;
                } else if (col == 0) {
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return ans;
    }
}