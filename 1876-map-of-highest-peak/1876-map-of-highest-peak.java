class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        Queue<int[]> qu = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    isWater[i][j] = 0;
                    qu.offer(new int[] { i, j });
                } else {
                    isWater[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int dx[] = { 1, -1, 0, 0 };
        int dy[] = { 0, 0, -1, 1 };

        while (!qu.isEmpty()) {
            int[] cell = qu.poll();
            for (int i = 0; i < 4; i++) {
                int row = cell[0] + dx[i];
                int col = cell[1] + dy[i];

                if(row>=0 && row <m && col >=0 && col<n && isWater[row][col] > isWater[cell[0]][cell[1]] +1){
                    isWater[row][col] = isWater[cell[0]][cell[1]] +1;
                    qu.offer(new int [] {row,col});
                }
            }
        }

        return isWater;
    }
}