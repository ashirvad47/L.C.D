class Solution {
    public int hIndex(int[] arr) {
        int n = arr.length;
        for (int h = 1; h <= n; h++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] >= h) {
                    count++;
                }
            }
            if (count < h) {
                return h - 1;
            }
        }
        return n;
    }
}
