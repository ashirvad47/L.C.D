class Solution {
    public int trap(int[] height) {
    int water = 0;
    int left = 0;
    int right = height.length - 1;
    int maxLeft = 0;
    int maxRight = 0;

    while (left <= right) {
        // Update maxLeft and maxRight
        maxLeft = Math.max(maxLeft, height[left]);
        maxRight = Math.max(maxRight, height[right]);

        // Calculate water trapped at current position
        if (maxLeft < maxRight) {
            water += Math.max(0, maxLeft - height[left]);
            left++;
        } else {
            water += Math.max(0, maxRight - height[right]);
            right--;
        }
    }

    return water;
}
}