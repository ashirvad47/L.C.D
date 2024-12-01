class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ls = new ArrayList<>();

        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));

        for (int i = 0; i < intervals.length; i++) {
            if (ls.isEmpty() || ls.get(ls.size() - 1)[1] < intervals[i][0])
                ls.add(intervals[i]);
            else
                ls.get(ls.size() - 1)[1] = Math.max(ls.get(ls.size() - 1)[1], intervals[i][1]);
        }

        return ls.toArray(new int[ls.size()][]);
    }
}