class Solution {
    static int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int rows;
    private int cols;
    
    public int largestIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        
        
        int[] areas = new int[rows * cols + 2];
        int areaIndex = 2;
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] != 1) continue;
                
                //save the area of this ones island in unique index
                areas[areaIndex] = getArea(grid, r, c, areaIndex);
                areaIndex++;
            }
        }
        
        int maxArea = 0;
        //max area without toggling zero
        for(int area : areas) maxArea = Math.max(area, maxArea);
        
        
        //max area after toggling zero to one
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] != 0) continue;
                
                Set<Integer> seenIsland = new HashSet();
                
                int area = 1;
                for(int[] dir : DIRECTIONS){
                    int x = r + dir[0];
                    int y = c + dir[1];
                    
                    if(isOutsideGrid(x, y)) continue;
                    
                    if(seenIsland.contains(grid[x][y])) continue;
                    
                    //mark as seen this island
                    seenIsland.add(grid[x][y]);
                    
                    //add the island area of current direction
                    area += areas[grid[x][y]];
                }
                
                maxArea = Math.max(area, maxArea);
            }
        }
        
        return maxArea;
    }
    
    
    private int getArea(int[][] grid, int r, int c, int areaIndex){
        if(isOutsideGrid(r, c)) return 0;
        
        if(grid[r][c] != 1) return 0;

        //marked Visited and assign a unique index,
        grid[r][c] = areaIndex;

        int area = 1;

        for(int[] dir : DIRECTIONS){
            int x = r + dir[0];
            int y = c + dir[1];

            area += getArea(grid, x, y, areaIndex);
        }

        return area;
    }
        
    private boolean isOutsideGrid(int r, int c){
        return r < 0 || r >= rows || c < 0 || c >= cols;
    }
}