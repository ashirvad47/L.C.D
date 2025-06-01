class Solution {
    public long distributeCandies(int n, int limit) {
        return comb(n, 3)
            - 3L * comb(n - (limit + 1), 3)
            + 3L * comb(n - 2 * (limit + 1), 3)
            - comb(n - 3 * (limit + 1), 3);
    }

    private long comb(int n, int k) {
        // C(n + k - 1, k - 1) for k = 3 => C(n + 2, 2)
        if (n < 0) return 0;
        return (long)(n + 2) * (n + 1) / 2;
    }
}