public class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = 0;
        for (int quantity : quantities) right = Math.max(right, quantity);

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(mid, n, quantities)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean canDistribute(int x, int n, int[] quantities) {
        int storesNeeded = 0;
        for (int quantity : quantities) {
            storesNeeded += (int) Math.ceil((double) quantity / x);
            if (storesNeeded > n) return false;
        }
        return true;
    }
}
