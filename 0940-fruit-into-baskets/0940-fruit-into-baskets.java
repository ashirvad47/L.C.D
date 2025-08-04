class Solution {
    public int totalFruit(int[] A) {
        Map<Integer, Integer> mp = new HashMap<>();
        int left = 0, ans = 0, n = A.length;
        int temp = 0;

        for (int right = 0; right < n; right++) {
            mp.merge(A[right], 1, Integer::sum);
            temp++;

            while (mp.size() > 2) {
                mp.merge(A[left], -1, Integer::sum);

                if (mp.get(A[left]) <= 0)
                    mp.remove(A[left]);
                left++;
                temp--;
            }
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}