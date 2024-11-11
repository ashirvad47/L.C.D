class Solution {
    public boolean primeSubOperation(int[] nums) {
        if (isSorted(nums)) {
            return true;
        }

        for (int i = 0; i < nums.length; i++) {
            int maxPossiblePrime = nums[i] - (i > 0 ? nums[i-1] : 0) - 1;
            
            if (maxPossiblePrime <= 1) {
                continue;
            }

            int primeToSubtract = findLargestPrime(maxPossiblePrime);
            if (primeToSubtract > 0) {
                nums[i] -= primeToSubtract;
            }

            if (isSorted(nums)) {
                return true;
            }
        }
        return false;
    }

    private int findLargestPrime(int n) {
        for (int i = n; i >= 2; i--) {
            if (isPrime(i)) {
                return i;
            }
        }
        return 0;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                return false;
            }
        }
        return true;
    }
}