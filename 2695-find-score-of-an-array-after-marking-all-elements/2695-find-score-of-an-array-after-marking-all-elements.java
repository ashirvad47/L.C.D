class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
        );

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        boolean[] marked = new boolean[nums.length];
        long score = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int value = current[0];
            int index = current[1];

            if (marked[index]) {
                continue;
            }

            score += value;

            marked[index] = true;
            if (index > 0) marked[index - 1] = true;
            if (index < nums.length - 1) marked[index + 1] = true;
        }

        return score;
    }
}
