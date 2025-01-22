class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] distances = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        // Step 1: Initialize distances and enqueue all `0` cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    pq.add(new int[]{i, j, 0}); // {row, col, distance}
                } else {
                    distances[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // Step 2: Directions for neighbors (right, left, down, up)
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Step 3: Process cells in priority queue
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0];
            int y = cell[1];
            int dist = cell[2];

            // If already visited, skip
            if (visited[x][y]) continue;
            visited[x][y] = true;

            // Update the distance
            distances[x][y] = dist;

            // Explore neighbors
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newY >= 0 && newX < m && newY < n && !visited[newX][newY]) {
                    pq.add(new int[]{newX, newY, dist + 1});
                }
            }
        }

        return distances;
    }
}