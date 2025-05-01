class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : stones) pq.offer(i);

        while(pq.size()>1 && !pq.isEmpty()){
            int yStone = pq.poll();
            int xStone = pq.poll();

            if(xStone==yStone) continue;
           else pq.offer(yStone-xStone);
            
        }

        return pq.isEmpty() ? 0:pq.poll();
    }
}