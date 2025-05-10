class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1=0,sum2=0;
        long zeroCount1=0, zeroCount2=0;
        for(long i : nums1) sum1+=i;
        for(long i : nums2) sum2+=i;

        for(long i : nums1) if(i==0) zeroCount1++;
        for(long i : nums2) if(i==0) zeroCount2++;

        if(sum1+zeroCount1 > sum2 && zeroCount2==0) return -1;
        if(sum2+zeroCount2 > sum1 && zeroCount1==0) return -1;

        return sum1+zeroCount1>sum2+zeroCount2 ?  sum1+zeroCount1: sum2+zeroCount2;
    }
}