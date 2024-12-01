class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for(int i :nums){
            set.add(i);
        }


        int maxCount=0;
        int count=0;
        Integer previous = null;
        for (Integer current : set) {
            if (previous != null && current - previous != 1) {
                count=0; 
            }
            count++;
            previous = current;

            maxCount = Math.max(count,maxCount);
        }
        return maxCount;
    }
}