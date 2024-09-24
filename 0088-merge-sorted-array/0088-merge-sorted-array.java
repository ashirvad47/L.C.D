// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         for(int i =0;i <n;i++){
//             nums1[i+m] += nums2[i];
//         }
//         Arrays.sort(nums1);
//     }
// }


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;  // Pointer for nums1, starting at the last meaningful element
        int p2 = n - 1;  // Pointer for nums2, starting at the last element
        int i = m + n - 1;  // Pointer for the last index in nums1 (where we'll insert values)

        // While there are elements left in nums2
        while (p2 >= 0) {
            // If nums1 still has elements to compare and the current element of nums1 is larger
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i--] = nums1[p1--];  // Place the larger element from nums1 at the end
            } 
            // Otherwise, place the element from nums2 into nums1
            else {
                nums1[i--] = nums2[p2--];
            }
        }
    }
}



// Key Concept:
// We are merging the arrays in reverse order to avoid overwriting values in nums1.
// We have three pointers:
// i starts at the last element of the meaningful part of nums1 (i.e., m-1).
// j starts at the last element of nums2 (i.e., n-1).
// k starts at the last index of nums1 (i.e., m + n - 1), which is the index where we place the largest elements during the merge.
// Initial State:
// i = 2 (pointing at 3 in nums1)
// j = 2 (pointing at 6 in nums2)
// k = 5 (pointing at the last element of nums1)
// Iteration 1:
// Compare nums1[i] = 3 and nums2[j] = 6.
// Since 6 > 3, we place 6 at nums1[k].
// nums1 becomes: [1, 2, 3, 0, 0, 6].
// Decrement j and k:
// j = 1 (now pointing at 5)
// k = 4
// Iteration 2:
// Compare nums1[i] = 3 and nums2[j] = 5.
// Since 5 > 3, we place 5 at nums1[k].
// nums1 becomes: [1, 2, 3, 0, 5, 6].
// Decrement j and k:
// j = 0 (now pointing at 2)
// k = 3
// Iteration 3:
// Compare nums1[i] = 3 and nums2[j] = 2.
// Since 3 > 2, we place 3 at nums1[k].
// nums1 becomes: [1, 2, 3, 3, 5, 6].
// Decrement i and k:
// i = 1 (now pointing at 2)
// k = 2
// Iteration 4:
// Compare nums1[i] = 2 and nums2[j] = 2.
// Since 2 <= 2, we place 2 from nums2 at nums1[k].
// nums1 becomes: [1, 2, 2, 3, 5, 6].
// Decrement j and k:
// j = -1 (no more elements left in nums2)
// k = 1
// Remaining Elements:
// At this point, we have finished processing nums2 (j = -1), but there are still elements in nums1. Since they are already in the correct position, we stop here. The merge is complete.

// Final Output:
// nums1 = [1, 2, 2, 3, 5, 6]

