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

        int freshOranges = 0;

        Queue<Vertex> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Vertex(i, j, 0));
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        if (freshOranges == 0) {
            return 0;
        }

        int[] directions = { -1, 0, 1, 0, -1 };
        int minutes = 0;

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            int row = current.row;
            int col = current.col;
            int time = current.time;

            minutes = time;

            for (int i = 0; i < directions.length - 1; i++) {
                int newRow = row + directions[i];
                int newCol = col + directions[i + 1];

                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                        && grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 2;
                    freshOranges--;
                    queue.offer(new Vertex(newRow, newCol, time + 1));
                }

            }
        }

        return (freshOranges == 0) ? minutes : -1;
    }
}

/*
Step-by-step summary:

1. **Vertex Class**: 
   - Defines a vertex with `row`, `col` (coordinates of the orange), and `time` (minutes passed since it rotted).

2. **Initialize Grid**:
   - Count all fresh oranges and add all rotten oranges to the queue with an initial time of 0.

3. **Edge Case**:
   - If there are no fresh oranges initially, return 0 since no time is needed.

4. **Breadth-First Search (BFS)**:
   - Use a queue to process rotten oranges.
   - For each rotten orange, check its 4 neighboring cells (up, down, left, right).
   - If a neighboring cell contains a fresh orange, mark it as rotten, decrease the fresh orange count, and add the new rotten orange to the queue with an incremented time.
   - Track the time for each level of BFS.

5. **Result**:
   - If all fresh oranges have become rotten, return the total minutes.
   - If there are any fresh oranges left that couldn't rot, return -1 (impossible case).
*/
