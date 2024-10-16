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


/*
1. Check if the matrix is null or empty, return false if it is.
2. Initialize `start` to 0 and `end` to m * n - 1 (treat the matrix as a 1D array).
3. Perform binary search while `start` <= `end`:
   a. Calculate the middle index: mid = start + (end - start) / 2.
   b. Convert the mid index to 2D coordinates: midVal = matrix[mid / n][mid % n].
   c. If midVal equals target, return true (target found).
   d. If midVal is greater than target, search the left half by updating end = mid - 1.
   e. If midVal is less than target, search the right half by updating start = mid + 1.
4. If the loop ends without finding the target, return false (target not found).
*/
