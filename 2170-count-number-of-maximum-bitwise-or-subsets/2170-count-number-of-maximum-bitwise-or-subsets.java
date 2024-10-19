class Solution {
    int maxOr = 0; // Store the maximum possible OR
    int count = 0; // Count subsets that result in maxOr

    public int countMaxOrSubsets(int[] nums) {
        // Step 1: Find the maximum OR possible by OR'ing all elements
        for (int num : nums) {
            maxOr |= num;
        }

        // Step 2: Start backtracking from the first element with an initial OR of 0
        backtrack(nums, 0, 0); // (array, current index, current OR value)

        // Step 3: Return the count of subsets with the maximum OR
        return count;
    }

    private void backtrack(int[] nums, int index, int currentOr) {
        // Base case: If we have processed all elements
        if (index == nums.length) {
            // If the current OR is equal to the maximum OR, increment the count
            if (currentOr == maxOr) {
                count++;
            }
            return;
        }

        // Recursive case: explore two options for each element

        // 1. Exclude the current element and move to the next
        backtrack(nums, index + 1, currentOr);

        // 2. Include the current element and update the OR
        backtrack(nums, index + 1, currentOr | nums[index]);
    }
    
}
