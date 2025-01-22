class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j]==0) queue.offer(new int[] {i,j});
                else mat[i][j] = Integer.MAX_VALUE;
            }
        }

        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,-1,1};

        while(queue.isEmpty()==false){
            int [] cell = queue.poll();
            for(int i =0; i < 4;i++){
                int row = cell[0]+dx[i];
                int col = cell[1]+dy[i];

                if(row>=0 && row<m && col >=0 && col < n && mat[row][col] > mat[cell[0]][cell[1]] + 1){
                    queue.offer(new int[] {row,col});
                    mat[row][col]=  mat[cell[0]][cell[1]] + 1;
                }
            }
        }

        return mat;

    }
}