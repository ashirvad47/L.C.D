class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int totalLength = n1 + n2;
        int[] mergedArray = new int[totalLength];

        int i = 0, j = 0, k = 0;

        // Merge both sorted arrays into a single sorted array
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }
        }

        // Copy remaining elements from nums1 (if any)
        while (i < n1) {
            mergedArray[k++] = nums1[i++];
        }

        // Copy remaining elements from nums2 (if any)
        while (j < n2) {
            mergedArray[k++] = nums2[j++];
        }

        // Find median
        if (totalLength % 2 == 0) {
            return (mergedArray[totalLength / 2 - 1] + mergedArray[totalLength / 2]) / 2.0;
        } else {
            return mergedArray[totalLength / 2];
        }
    }
}
