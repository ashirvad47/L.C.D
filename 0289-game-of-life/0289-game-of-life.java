import java.util.concurrent.*;

class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        int[] rowDir = { -1, -1, -1, 0, 1, 1, 1, 0 };
        int[] colDir = { -1, 0, 1, 1, 1, 0, -1, -1 };

        // Executor to run multiple threads
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // Divide the board into rows, each thread handles a portion of the board
        List<Callable<Void>> tasks = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            final int rowIdx = i;
            tasks.add(() -> {
                for (int j = 0; j < col; j++) {
                    int liveNeighbors = 0;

                    // Count live neighbors
                    for (int k = 0; k < 8; k++) {
                        int newRow = rowIdx + rowDir[k];
                        int newCol = j + colDir[k];

                        if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && (board[newRow][newCol] % 2 == 1)) {
                            liveNeighbors++;
                        }
                    }

                    // Apply the Game of Life rules
                    if (board[rowIdx][j] == 1 && (liveNeighbors == 2 || liveNeighbors == 3)) {
                        board[rowIdx][j] += 2; // Cell remains alive in the next generation
                    } else if (board[rowIdx][j] == 0 && liveNeighbors == 3) {
                        board[rowIdx][j] += 2; // Cell becomes alive in the next generation
                    }

                }
                return null;
            });
        }

        try {
            // Execute tasks in parallel
            executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Second pass: Finalize the board state by dividing by 2
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] /= 2; // Finalize the state (0 or 1)
            }
        }

        // Shut down the executor after completion
        executor.shutdown();
    }
}
