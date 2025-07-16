class Solution {
    public int maximumLength(int[] nums) {
        int oddSumSeq = 1, oddCount = 0, lastBit = (nums[0]&1);
        
        for( int n : nums ){
            int currBit = n&1;
            oddSumSeq += currBit ^ lastBit;
            oddCount += currBit;
            lastBit = currBit;
        }

        return Math.max( oddSumSeq, Math.max(oddCount, nums.length - oddCount) );
    }
}