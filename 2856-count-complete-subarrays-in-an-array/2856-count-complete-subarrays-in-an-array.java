class Solution {
    public int countCompleteSubarrays(int[] nums) {
        
        Set<Integer> distinct = new HashSet<>();
        for (int num : nums) {
            distinct.add(num);
        }
        int totalDistinct = distinct.size();
        
        if (totalDistinct == 1) {
            return (nums.length * (nums.length + 1)) / 2;
        }
        
        Map<Integer, Integer> window = new HashMap<>();
        int left = 0;
        int result = 0;
        
        for (int right = 0; right < nums.length; right++) {

            window.put(nums[right], window.getOrDefault(nums[right], 0) + 1);
            
            while (window.size() == totalDistinct) {

                result += nums.length - right;
                int leftVal = nums[left];
                window.put(leftVal, window.get(leftVal) - 1);
                if (window.get(leftVal) == 0) {
                    window.remove(leftVal);
                }
                left++;
            }
        }
        
        return result;
    }
}