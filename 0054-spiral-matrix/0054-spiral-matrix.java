class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        
        while (res.size() < m * n) {
            // Traverse right
            for (int j = left; j <= right && res.size() < m * n; j++) {
                res.add(matrix[top][j]);
            }
            top++;
            
            // Traverse down
            for (int i = top; i <= bottom && res.size() < m * n; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            
            // Traverse left
            for (int j = right; j >= left && res.size() < m * n; j--) {
                res.add(matrix[bottom][j]);
            }
            bottom--;
            
            // Traverse up
            for (int i = bottom; i >= top && res.size() < m * n; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        
        return res;
    }
}