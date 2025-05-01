class Solution {
    public int minimumDifference(int[] nums) {
        int m = nums.length, N = m/2;
        int total = 0;
        for (int x : nums) total += x;

        // 1) split into two halves
        int[] A = Arrays.copyOfRange(nums, 0, N);
        int[] B = Arrays.copyOfRange(nums, N, m);

        // 2) generate all sums by pick‐count for each half
        List<List<Integer>> sumsA = new ArrayList<>(N+1);
        List<List<Integer>> sumsB = new ArrayList<>(N+1);
        for (int i = 0; i <= N; i++) {
            sumsA.add(new ArrayList<>());
            sumsB.add(new ArrayList<>());
        }

        // helper to fill sumsX
        fillSubSums(A, sumsA);
        fillSubSums(B, sumsB);

        // 3) sort each sumsB[k] for binary‐search
        for (int k = 0; k <= N; k++) {
            Collections.sort(sumsB.get(k));
        }

        int best = Integer.MAX_VALUE;
        int half = total / 2;

        // 4) meet‐in‐the‐middle: for each pick‐count k in first half,
        //    look in second half at pick‐count N-k
        for (int k = 0; k <= N; k++) {
            List<Integer> listA = sumsA.get(k);
            List<Integer> listB = sumsB.get(N - k);
            for (int s1 : listA) {
                // target sum for s2 to get close to total/2
                int tgt = half - s1;
                int idx = Collections.binarySearch(listB, tgt);
                if (idx < 0) idx = -idx - 1;

                // check the two neighbors around insertion point
                if (idx < listB.size()) {
                    int s2 = listB.get(idx);
                    best = Math.min(best, Math.abs(total - 2*(s1 + s2)));
                }
                if (idx > 0) {
                    int s2 = listB.get(idx - 1);
                    best = Math.min(best, Math.abs(total - 2*(s1 + s2)));
                }
            }
        }

        return best;
    }

    // Enumerate all subsets of arr, grouping their sums by subset-size
    private void fillSubSums(int[] arr, List<List<Integer>> sums) {
        int n = arr.length;
        int maxMask = 1 << n;
        for (int mask = 0; mask < maxMask; mask++) {
            int cnt = Integer.bitCount(mask);
            int s = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    s += arr[i];
                }
            }
            sums.get(cnt).add(s);
        }
    }
}
