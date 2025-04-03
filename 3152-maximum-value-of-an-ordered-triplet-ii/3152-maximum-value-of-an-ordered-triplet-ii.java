class Solution {
    public long maximumTripletValue(int[] nums) {
        long res=0, curr=0, diff=0;
        for(int x : nums){
            res = Math.max(res,diff*x);
            curr= Math.max(curr, x);
            diff = Math.max(diff,curr-x);
        }

        return res;
    }
}