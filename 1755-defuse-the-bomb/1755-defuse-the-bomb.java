class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];

        if (k > 0) {
            // Sum of the next k elements
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= k; j++) {
                    int temp = (i + j) % n; // Wrap around using modulus
                    res[i] += code[temp];
                }
            }
        } else if (k < 0) {
            // Sum of the previous |k| elements
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= -k; j++) {
                    int temp = (i - j + n) % n; // Wrap around for negative indices
                    res[i] += code[temp];
                }
            }
        } else {
            // k == 0, return array with all zeros (already initialized)
            return res;
        }

        return res;
    }
}
