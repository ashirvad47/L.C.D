class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dx = {0, 0, 1, -1}; // Right, Left, Down, Up
        int[] dy = {1, -1, 0, 0};
        int[][] cost = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        
        // Initialize cost array with max values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // Priority queue to store (cost, row, col)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0}); // cost, row, col
        cost[0][0] = 0;
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentCost = current[0], x = current[1], y = current[2];
            
            if (visited[x][y]) continue;
            visited[x][y] = true;
            
            // If we reach the bottom-right corner
            if (x == m - 1 && y == n - 1) {
                return currentCost;
            }
            
            // Explore all 4 directions
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int newCost = currentCost + (grid[x][y] == d + 1 ? 0 : 1); // 0 if direction matches, 1 otherwise
                    
                    if (newCost < cost[nx][ny]) {
                        cost[nx][ny] = newCost;
                        pq.offer(new int[]{newCost, nx, ny});
                    }
                }
            }
        }
        
        return -1; // Shouldn't reach here
    }
}
