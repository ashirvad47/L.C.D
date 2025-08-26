class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea=0;
        int maxDiag=0;
        for(int[] dimension:dimensions){
            int diag=dimension[0]*dimension[0]+dimension[1]*dimension[1];
            if(diag>maxDiag){
                maxDiag=diag;
                maxArea=dimension[0]*dimension[1];
            }else if(diag==maxDiag){
                maxArea=Math.max(maxArea,dimension[0]*dimension[1]);
            }
        }
        return maxArea;
    }
}