
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = basket1.length;

        for (int i = 0; i < n; i++) {
            freq.put(basket1[i], freq.getOrDefault(basket1[i], 0) + 1);
            freq.put(basket2[i], freq.getOrDefault(basket2[i], 0) - 1);
        }

        List<Integer> excess = new ArrayList<>();
        int minElement = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int val = entry.getKey();
            int count = entry.getValue();

            // If odd count, not possible to split evenly
            if (count % 2 != 0) return -1;

            // Save half the excess to swap later
            for (int i = 0; i < Math.abs(count) / 2; i++) {
                excess.add(val);
            }

            minElement = Math.min(minElement, val);
        }

        // Sort to swap smallest with smallest
        Collections.sort(excess);

        long cost = 0;
        int m = excess.size();

        for (int i = 0; i < m / 2; i++) {
            cost += Math.min(excess.get(i), 2 * minElement);
        }

        return cost;
    }
}