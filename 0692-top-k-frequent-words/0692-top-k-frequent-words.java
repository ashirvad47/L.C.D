class Solution {
    public List<String> topKFrequent(String[] words, int k) {
      HashMap<String, Integer> map = new HashMap <>();
        List<String> ls = new ArrayList<>();
      for(String i:words){
        map.put(i,map.getOrDefault(i,0)+1);
      }  
      PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(b) == map.get(a) ? a.compareTo(b) : Integer.compare(map.get(b), map.get(a)));
      pq.addAll(map.keySet());
      for(int i =0;i <k;i++){
        ls.add(pq.poll());
      }
      
      return ls;
    }
}