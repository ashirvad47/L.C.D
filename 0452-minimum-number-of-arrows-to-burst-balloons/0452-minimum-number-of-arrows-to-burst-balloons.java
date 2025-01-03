class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int end = points[0][1]; 

        for (int[] point : points) {
            if (point[0] > end) { 
                arrows++;
                end = point[1];
            }
        }

        return arrows;
    }
}
