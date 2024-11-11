class Solution {
    public boolean primeSubOperation(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i] - 1; j >= 1 ; j--) { // stricktly lesser than nums[i]
                if (isPrime(j)) {
                    int temp = nums[i]-j;

                    if(i==0 || temp> nums[i-1]){ //i==0 to prevent index out of bounds
                        nums[i]=temp;
                        break;
                    }
                }
            }
            if (isSorted(nums)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

}