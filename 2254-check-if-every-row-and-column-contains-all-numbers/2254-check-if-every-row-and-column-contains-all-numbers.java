import java.util.HashSet;

class Solution {
    public boolean checkValid(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> x = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (!x.add(matrix[i][j])) { 
                    return false;
                }
            }

            HashSet<Integer> y = new HashSet<>();
            for (int j = 0; j <matrix.length ; j++) {
                if (!y.add(matrix[j][i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
