class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer,Integer> map = new HashMap<>();
        int[] result = new int[k];
        for(int i :nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> Integer.compare(map.get(b),map.get(a)));
           queue.addAll(map.keySet());
        
        for(int i =0;i <k;i++){
            result[i]=queue.poll();
        }
        return result;
    }
}