class Solution {
    public int findMinArrowShots(int[][] points) {
        List<int[]> ls = new ArrayList<>();

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        for (int[] i : points) {
            if (ls.isEmpty() || ls.get(ls.size() - 1)[1] < i[0]) {
                ls.add(i); 
            }
        }

        return ls.size();
    }
}
