class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i :nums){
            set.add(i);
        }

        int maxCount=0;
        for(int i =0;i < nums.length;i++){
            int count =1;
            if(!set.contains(nums[i]-1)){
                int x=nums[i];
                while(set.contains(++x)){
                    count++;
                }
            }
            maxCount = Math.max(count,maxCount);
        }

        return maxCount;
        
    }
}