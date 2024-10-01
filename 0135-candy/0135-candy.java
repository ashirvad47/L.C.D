import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int count = 0;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && arr[i] <= arr[i + 1]) {
                arr[i] = arr[i + 1] + 1;
            }
        }

        for (int i : arr) count += i;

        return count;
    }
}