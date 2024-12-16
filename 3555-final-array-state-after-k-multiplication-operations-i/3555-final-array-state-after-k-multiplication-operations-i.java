class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> qu = new PriorityQueue<>((a, b) -> a.val !=b.val? a.val-b.val:a.idx-b.idx);

        int j = 0;
        for (int i : nums) {
            qu.offer(new Pair(i, j));
            j++;
        }

        while (k > 0) {
            k--;
            Pair top = qu.poll();
            top.val *= multiplier;
            qu.offer(top);
        }

        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            nums[p.idx] = p.val;
        }

        return nums;
    }
}

class Pair {
    int val;
    int idx;

    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}
