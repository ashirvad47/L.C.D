class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int[] firstHalf = Arrays.copyOfRange(nums, 0, n);
        int[] secondHalf = Arrays.copyOfRange(nums, n, nums.length);
        
        List<Integer>[] firstHalfSums = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            firstHalfSums[i] = new ArrayList<>();
        }
        
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            int count = Integer.bitCount(mask);
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += firstHalf[i];
                }
            }
            
            firstHalfSums[count].add(sum);
        }
        
        for (int i = 0; i <= n; i++) {
            Collections.sort(firstHalfSums[i]);
        }
        
        int minDiff = Integer.MAX_VALUE;
        
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            int count = Integer.bitCount(mask);
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += secondHalf[i];
                }
            }
            
            List<Integer> complementSums = firstHalfSums[n - count];
            
            if (!complementSums.isEmpty()) {
                int target = (totalSum - 2 * sum) / 2;
                
                int idx = binarySearch(complementSums, target);
                int firstSum = complementSums.get(idx) + sum;
                int secondSum = totalSum - firstSum;
                minDiff = Math.min(minDiff, Math.abs(firstSum - secondSum));
                
                if (idx < complementSums.size() - 1) {
                    firstSum = complementSums.get(idx + 1) + sum;
                    secondSum = totalSum - firstSum;
                    minDiff = Math.min(minDiff, Math.abs(firstSum - secondSum));
                }
            }
        }
        
        return minDiff;
    }
    
    private int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        
        if (list.get(left) >= target) return left;
        if (list.get(right) <= target) return right;
        
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            
            if (list.get(mid) <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
}