class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2; 
        
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int[] firstHalf = Arrays.copyOfRange(nums, 0, n);
        int[] secondHalf = Arrays.copyOfRange(nums, n, nums.length);
        
        Map<Integer, List<Integer>> firstHalfSums = new HashMap<>();
        
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            int count = 0;
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += firstHalf[i];
                    count++;
                }
            }
            
            firstHalfSums.putIfAbsent(count, new ArrayList<>());
            firstHalfSums.get(count).add(sum);
        }
        
        for (List<Integer> sums : firstHalfSums.values()) {
            Collections.sort(sums);
        }
        
        int minDiff = Integer.MAX_VALUE;
        
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            int count = 0;
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += secondHalf[i];
                    count++;
                }
            }
            
            if (firstHalfSums.containsKey(n - count)) {
                List<Integer> complementSums = firstHalfSums.get(n - count);
                
                int target = (totalSum - 2 * sum) / 2;
                int idx = Collections.binarySearch(complementSums, target);
                
                if (idx >= 0) {
                    int firstSum = complementSums.get(idx) + sum;
                    int secondSum = totalSum - firstSum;
                    minDiff = Math.min(minDiff, Math.abs(firstSum - secondSum));
                } 
                else {
                    idx = -idx - 1;
                    
                    if (idx < complementSums.size()) {
                        int firstSum = complementSums.get(idx) + sum;
                        int secondSum = totalSum - firstSum;
                        minDiff = Math.min(minDiff, Math.abs(firstSum - secondSum));
                    }
                    
                    if (idx > 0) {
                        int firstSum = complementSums.get(idx - 1) + sum;
                        int secondSum = totalSum - firstSum;
                        minDiff = Math.min(minDiff, Math.abs(firstSum - secondSum));
                    }
                }
            }
        }
        
        return minDiff;
    }
}