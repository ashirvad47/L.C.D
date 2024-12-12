class Solution {
    public long pickGifts(int[] gifts, int k) {
        Queue <Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i :gifts){
            pq.offer(i);
        }

        for(int i =0;i < k;i++){
            int temp = (int) Math.sqrt(pq.poll());
            pq.offer(temp);
        }

        long sum=0;

        for(int i : pq){
            sum+=i;
        }

        return sum;
    }
}