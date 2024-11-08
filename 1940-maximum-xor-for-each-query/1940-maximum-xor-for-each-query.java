class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int maxXorValue = (1 << maximumBit) - 1;
        int totalXor = 0;
        
        // First calculate the total XOR
        for (int num : nums) {
            totalXor ^= num;
        }
        
        // Reverse the array in-place
        for (int i = 0; i < n/2; i++) {
            int temp = nums[i];
            nums[i] = nums[n-1-i];
            nums[n-1-i] = temp;
        }
        
        // Now process each element
        int runningXor = totalXor;
        for (int i = 0; i < n; i++) {
            int original = nums[i];  // Save original value
            nums[i] = runningXor ^ maxXorValue;  // Calculate result
            runningXor ^= original;  // Remove this number's contribution for next iteration
        }
        
        return nums;
    }
}