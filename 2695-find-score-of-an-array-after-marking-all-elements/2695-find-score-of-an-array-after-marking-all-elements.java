class Pair {
    int val;
    int ind;

    Pair(int val, int ind) {
        this.val = val;
        this.ind = ind;
    }
}

class Solution {
    public long findScore(int[] nums) {
        Queue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> 
            a.val == b.val ? a.ind - b.ind : a.val - b.val
        );

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            pq.add(new Pair(nums[i], i));
        }

        boolean[] marked = new boolean[n];
        long result = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int val = current.val;
            int ind = current.ind;

            if (!marked[ind]) {
                result += val;
                marked[ind] = true;

                if (ind > 0) {
                    marked[ind - 1] = true;
                }
                if (ind < n - 1) {
                    marked[ind + 1] = true;
                }
            }
        }

        return result;
    }
}
