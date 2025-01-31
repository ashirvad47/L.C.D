class Solution {
    // Union Find class to help track islands and their sizes
    class UnionFind {
        private int[] parent;
        private int[] size;
        
        public UnionFind(int n) {
            // Initialize with n*n elements since we have an n*n grid
            parent = new int[n * n];
            size = new int[n * n];
            // Initially, each cell is its own parent with size 1
            for (int i = 0; i < n * n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        // Find the root parent of a set
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }
        
        // Union two sets together
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                // Merge smaller set into larger set
                if (size[rootX] < size[rootY]) {
                    int temp = rootX;
                    rootX = rootY;
                    rootY = temp;
                }
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
        
        // Get size of the set containing x
        public int getSize(int x) {
            return size[find(x)];
        }
    }
    
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(n);
        
        // Direction arrays for checking 4 adjacent cells
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // First pass: Build initial islands using UnionFind
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int index = i * n + j;
                    // Check all 4 directions
                    for (int k = 0; k < 4; k++) {
                        int newRow = i + dx[k];
                        int newCol = j + dy[k];
                        // If neighbor is valid and is 1, union them
                        if (isValid(newRow, newCol, n) && grid[newRow][newCol] == 1) {
                            uf.union(index, newRow * n + newCol);
                        }
                    }
                }
            }
        }
        
        // Keep track of maximum island size
        int maxSize = 0;
        
        // Second pass: Try changing each 0 to 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    // Use a Set to avoid counting same island multiple times
                    Set<Integer> neighborIslands = new HashSet<>();
                    // Check all 4 directions
                    for (int k = 0; k < 4; k++) {
                        int newRow = i + dx[k];
                        int newCol = j + dy[k];
                        // If neighbor is valid and is 1, add its island root to set
                        if (isValid(newRow, newCol, n) && grid[newRow][newCol] == 1) {
                            neighborIslands.add(uf.find(newRow * n + newCol));
                        }
                    }
                    // Calculate size if we change this 0 to 1
                    int size = 1; // Start with 1 for the cell we're changing
                    for (int root : neighborIslands) {
                        size += uf.getSize(root);
                    }
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        
        // If maxSize is still 0, it means there were no 0s to change
        // In this case, return the size of any island (they're all connected)
        return maxSize == 0 ? n * n : maxSize;
    }
    
    // Helper method to check if coordinates are valid
    private boolean isValid(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}