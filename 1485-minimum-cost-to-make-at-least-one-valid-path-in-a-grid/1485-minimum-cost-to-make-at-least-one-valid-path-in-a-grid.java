class Solution {
    public int minCost(int[][] grid) {
        int[] dx = {0, 0, 1, -1}; // For right, left, down, up
        int[] dy = {1, -1, 0, 0};

        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[] { 0, 0, 0 }); 

        int[][] cost = new int[grid.length][grid[0].length];

        // Initialize cost array to Integer.MAX_VALUE
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }

        cost[0][0] = 0; // Starting point has cost 0

        // Start processing the queue
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currCost = current[0];
            int x = current[1];
            int y = current[2];

            // If we reach the bottom-right corner, return the current cost
            if (x == grid.length - 1 && y == grid[0].length - 1) {
                return currCost;
            }
            
            if (currCost > cost[x][y]) {
                continue;
            }

            // Explore the 4 possible directions
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {

                    int newCost = currCost + (grid[x][y] == i + 1 ? 0 : 1);

                    if (newCost < cost[nx][ny]) {
                        cost[nx][ny] = newCost;
                        pq.offer(new int[]{newCost, nx, ny});
                    }
                }
            }
        }

        return cost[grid.length-1][grid[0].length-1];
    }
}
