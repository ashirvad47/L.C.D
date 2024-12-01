class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ls = new ArrayList<>();
        boolean isInserted = false;

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                ls.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                if (!isInserted) {
                    ls.add(newInterval);
                    isInserted = true;
                }
                ls.add(intervals[i]);

            } else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }

       if (!isInserted) {
            ls.add(newInterval);
        }

        return ls.toArray(new int[ls.size()][2]);
    }
}