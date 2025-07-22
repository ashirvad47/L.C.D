class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int resMax = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = 0; 
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        
            Integer prevIndex = map.put(nums[i], i);
            if (prevIndex != null) {
                if (prevIndex >= j) {
                    for (int k = j; k <= prevIndex; k++) {
                        sum -= nums[k];
                    }
                    j = prevIndex + 1;
                }
            }
        
            resMax = Math.max(resMax, sum);
        }
        
        return resMax;
    }
}