class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        for(int i :nums){
            set.add(i);
        }
        int count=0;
        int start=0;
        for(int i=0;i < nums.length;i++){
            if(!set.contains(nums[i]-1)){
                start=nums[i];
                count = Math.max(count,howLong(set,start));
            }
            
        }
        return count;
    }

    private int howLong(HashSet<Integer> set, int start) {
        if (!set.contains(start)) {
            return 0;
        }
        return 1 + howLong(set, start + 1);
    }
    
}