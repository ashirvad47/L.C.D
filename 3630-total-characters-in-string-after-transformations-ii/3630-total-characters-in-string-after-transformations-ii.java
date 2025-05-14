class Solution {
    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[][] mat = new long[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < nums.get(i); j++) {
                mat[i][(i + 1 + j) % 26]++;
            }
        }

        long[][] res = new long[26][26];
        for (int i = 0; i < 26; i++) res[i][i] = 1;
        while (t > 0) {
            if ((t & 1) == 1) res = multiply(res, mat);
            mat = multiply(mat, mat);
            t >>= 1;
        }

        long[] freq = new long[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        long[] finalFreq = new long[26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                finalFreq[j] = (finalFreq[j] + freq[i] * res[i][j]) % MOD;
            }
        }

        long total = 0;
        for (long val : finalFreq) total = (total + val) % MOD;
        return (int) total;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length, m = B[0].length, k = B.length;
        long[][] res = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < k; l++) {
                    res[i][j] = (res[i][j] + A[i][l] * B[l][j]) % MOD;
                }
            }
        }
        return res;
    }
}
