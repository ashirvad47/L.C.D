class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long result = 0;
        int count = 0;

        // Map to store frequency of prefix counts modulo `modulo`
        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1); // base case

        for (int i : nums) {
            // Increase count only if num % modulo == k
            if (i % modulo == k) {
                count++;
            }

            // Current prefix sum modulo
            int currMod = count % modulo;

            // Find how many previous prefixes would make a subarray satisfying the condition
            int targetMod = (currMod - k + modulo) % modulo;
            result += freqMap.getOrDefault(targetMod, 0);

            // Update the frequency map
            freqMap.put(currMod, freqMap.getOrDefault(currMod, 0) + 1);
        }

        return result;
    }
}
