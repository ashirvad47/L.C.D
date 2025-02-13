class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> qu = new PriorityQueue<>();

        for(int i:  nums){
            qu.offer((long)i);
        }

        int count =0;

        while(qu.peek()<k){
            long first=qu.poll();
            long second = qu.poll();

            long n = Math.min(first,second)*2 + Math.max(first,second);

            qu.offer(n);
            count++;

        }

        return count;
    }
}