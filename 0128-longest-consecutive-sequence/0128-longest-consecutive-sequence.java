class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        for(int i :nums){
            set.add(i);
        }
        
        int maxCount=0;
        for(int i=0;i < nums.length;i++){
            int count=1;
            int x=nums[i];
            if (!set.contains(x - 1)) { 
                count = 1;
                while (set.contains(x + 1)) {
                    x++;  
                    count++;
                }
            }
            maxCount= Math.max(maxCount,count);
        }
        return maxCount;
    }

    
}