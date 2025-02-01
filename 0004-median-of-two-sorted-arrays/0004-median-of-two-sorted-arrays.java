class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> mergedList = new ArrayList<>();

        for (int num : nums1) {
            mergedList.add(num);
        }
        for (int num : nums2) {
            mergedList.add(num);
        }

        Collections.sort(mergedList);

        int size = mergedList.size();

        if (size % 2 == 1) {
            return mergedList.get(size / 2); 
        } else {
            return (mergedList.get(size / 2 - 1) + mergedList.get(size / 2)) / 2.0;
        }
    }
}
