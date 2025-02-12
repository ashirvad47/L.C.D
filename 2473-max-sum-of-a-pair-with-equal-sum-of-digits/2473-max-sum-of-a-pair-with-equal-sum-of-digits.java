class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int maxSum = -1;

        for (int num : nums) {
            int key = digSum(num);
            if (!map.containsKey(key)) {
                map.put(key, new int[]{num, -1}); 
            } else {
                int[] topTwo = map.get(key);

                if (num > topTwo[0]) {
                    topTwo[1] = topTwo[0];
                    topTwo[0] = num;
                } else if (num > topTwo[1]) {
                    topTwo[1] = num;
                }

                if (topTwo[1] != -1) {
                    maxSum = Math.max(maxSum, topTwo[0] + topTwo[1]);
                }
            }
        }
        
        return maxSum;
    }

    private int digSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
