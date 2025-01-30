class Solution {
    public int findPairs(int[] nums, int k) {
        // if(k<0) return 0;
        int count =0;
        if(k==0){
            HashMap<Integer, Integer> map = new HashMap<>();
             for(int i: nums){
                map.put(i, map.getOrDefault(i,0)+1);
            }

            for (int key : map.keySet()) {
                if (map.get(key) > 1) count++;
            }
        }else {
            HashSet<Integer> set = new HashSet<>();

            for(int i: nums){
                set.add(i);
            }
        
        for(int i: set){
            int target=i+k;

            if(set.contains(target)) count++;
        }
        }

        

        return count;
    }
}