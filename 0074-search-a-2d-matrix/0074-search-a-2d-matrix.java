class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int start=0;
        int end= m*n-1;

        while(start<=end){
            int mid = start+(end-start)/2;
            int midVal= matrix[mid/n][mid%n];

            if(midVal==target){
                return true;
            }
            else if (midVal>target){
                end = mid -1;
            }
            else {
                start = mid +1 ;
            }
        }
        return false;
    }
}
