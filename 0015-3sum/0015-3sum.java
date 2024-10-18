class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Sort the array
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for the second pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for the third pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // Move both pointers
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // We need a larger sum
                } else {
                    right--; // We need a smaller sum
                }
            }
        }
        
        return result;
    }
}


/*
This solution finds all unique triplets in the array that sum up to zero.

1. Initial Input and Setup:
   - The input is an unsorted array of integers `nums[]`.
   - The goal is to find unique triplets such that `nums[i] + nums[left] + nums[right] = 0`.
   
   Example input: `nums = [-1, 0, 1, 2, -1, -4]`

   We start by creating an empty list `result` to store the triplets.
   Then, we sort the input array `nums`.

   After sorting:
   Sorted nums = [-4, -1, -1, 0, 1, 2]

2. Main Loop (Iterating Over the Array):
   - The outer loop starts at `i = 0` and iterates through the array.
   - For each `i`, two pointers are set:
     - `left = i + 1` (the next element after `nums[i]`)
     - `right = nums.length - 1` (the last element in the array)
   
3. Skipping Duplicates for `i`:
   - Before entering the inner loop, we skip any duplicates for `i`.
   - If `nums[i] == nums[i - 1]`, the loop continues to avoid repeating triplets.
   
   For example: 
   For `i = 0`, `nums[i] = -4`. No duplicates, so we proceed.

4. Finding Triplets Using the Two-Pointer Technique:
   - Inside the while loop, we calculate the sum:
     sum = `nums[i] + nums[left] + nums[right]`
   
   - There are 3 cases:
     a) If `sum == 0`:
        - A valid triplet is found! Add `[nums[i], nums[left], nums[right]]` to `result`.
        - Skip any duplicates for `left` and `right` pointers to avoid duplicate triplets.
        - Move both `left++` and `right--` to continue.
     
     b) If `sum < 0`:
        - The sum is too small, increment `left++` to move to a larger value.

     c) If `sum > 0`:
        - The sum is too large, decrement `right--` to move to a smaller value.

5. Step-by-Step Example:
   Let's break down how this works for our input:

   For `i = 0`, `nums[i] = -4`:
   - `left = 1`, `right = 5`, sum = `-4 + (-1) + 2 = -3` → Increment `left`.
   - `left = 2`, `right = 5`, sum = `-4 + (-1) + 2 = -3` → Increment `left`.
   - `left = 3`, `right = 5`, sum = `-4 + 0 + 2 = -2` → Increment `left`.
   - `left = 4`, `right = 5`, sum = `-4 + 1 + 2 = -1` → Increment `left`.
   - `left` crosses `right`, stop.

   For `i = 1`, `nums[i] = -1`:
   - `left = 2`, `right = 5`, sum = `-1 + (-1) + 2 = 0` → Found triplet `[-1, -1, 2]`.
   - Skip duplicates for `left` and `right`.
   - Move `left = 3`, `right = 4`, sum = `-1 + 0 + 1 = 0` → Found triplet `[-1, 0, 1]`.
   - Move both pointers, `left` crosses `right`, stop.

   For `i = 2`, `nums[i] = -1` (duplicate):
   - Skip this iteration.

   For `i = 3`, `nums[i] = 0`:
   - `left = 4`, `right = 5`, sum = `0 + 1 + 2 = 3` → Decrement `right`.
   - `left` crosses `right`, stop.

6. Returning the Result:
   - After the loops complete, `result` contains the unique triplets that sum to zero.

   Final result for this example:
   result = [[-1, -1, 2], [-1, 0, 1]]

7. Summary of the Solution:
   - Sort the array first.
   - Use a loop to iterate through the elements.
   - For each element, apply the two-pointer technique to find triplets.
   - Skip duplicates to avoid repeating triplets.
   - The time complexity is O(n^2) due to sorting and the two-pointer approach.
*/
