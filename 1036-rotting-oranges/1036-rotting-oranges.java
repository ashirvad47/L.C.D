class Solution {
    class Vertex {
    int row;
    int col;
    int time; 

    public Vertex(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;

        Queue<Vertex> queue = new LinkedList<>();

        for(int i =0; i < m;i++){
            for (int j =0;j<n;j++){
                if(grid[i][j]==2){
                    queue.offer(new Vertex(i,j,0));
                }else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        if (freshOranges==0){
            return 0;
        }

        int[] directions = {-1,0,1,0,-1};
        int minutes =0;

        while(!queue.isEmpty()){
            Vertex current = queue.poll();
            int row = current.row;
            int col = current.col;
            int time = current.time;

            minutes = time;

            for(int i =0;i<directions.length-1;i++){
                int newRow = row + directions[i];
                int newCol = col + directions[i+1];

                if(newRow >=0 && newRow<m && newCol>=0 && newCol <n && grid[newRow][newCol]==1){
                    grid[newRow][newCol]=2;
                    freshOranges--;
                    queue.offer(new Vertex(newRow,newCol, time+1));
                }

            }
        }

        return (freshOranges ==0 ) ? minutes : -1;
    }
}