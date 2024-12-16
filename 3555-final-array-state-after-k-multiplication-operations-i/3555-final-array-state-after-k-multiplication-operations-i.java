class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.val != b.val ? a.val - b.val : a.idx - b.idx);

        for (int i = 0; i < nums.length; i++) {
            queue.offer(new Pair(nums[i], i));
        }

        while (k-- > 0) {
            Pair smallest = queue.poll();
            smallest.val *= multiplier;
            queue.offer(smallest);
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            nums[pair.idx] = pair.val;
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
