class Solution {
    public long countSubarrays(int[] nums, int k) {
        // HashMap<Integer,Integer> map = new HashMap<>();

        // for(int i :  nums) map.put(i,map.getOrDefault(i,0)+1);
        // List<Integer> ls = new ArrayList<>();
        // for(HashMap.Entry<Integer,Integer> e : map.entrySet()){
        //     if(e.getValue()>=k) ls.add(e.getKey());
        // }

        // if(ls.isEmpty()) return 0l;
        if(k>nums.length) return 0l;

        int max = Integer.MIN_VALUE;

        for(int i : nums) if(i >max) max =i;

        long count =0;

        int freq=0;

        for(int right =0,left =0; right < nums.length;right++ ){
            if(nums[right]==max) freq++;
            while(freq>=k){
                count += nums.length - right;
                if(nums[left]==max) freq--;
                left++;
            }
        }

        return count;


    }
}