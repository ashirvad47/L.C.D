class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        int max = 0;
        for(int candy : candies)
            max = Math.max(max, candy);
        int lo = 0, hi = max;
        
        while(lo < hi) {            
            int mid = lo + (hi-lo)/2;
            if(canAllocate(candies, k, mid)) {
                lo = mid+1;
            } else {
                hi = mid ;
            }
        }  
        return canAllocate(candies, k, lo) ? lo : lo-1;
    }
    
    public boolean canAllocate(int[] candies, long k, int allow) {
        if(allow == 0)
            return true;
        long total = 0;
        for(int candy : candies) {
            total += candy / allow;
            if(total >= k)
                return true;
        }
        return false;
    }
}