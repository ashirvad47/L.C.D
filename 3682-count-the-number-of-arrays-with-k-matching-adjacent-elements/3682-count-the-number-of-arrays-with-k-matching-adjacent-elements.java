class Solution {
    private static final int MOD = 1000000007;
    private long power(long x, long y) {
        long result = 1;
        x = x % MOD;
        while (y > 0) {
            if ((y & 1) == 1)   result = (result * x) % MOD;
            x = (x * x) % MOD;
            y = y >> 1;
        }
        return result;
    }
    
    private long modInverse(long a) {
        return power(a, MOD - 2);
    }
    private long nCr(long n, long r) {
        if (r > n)  return 0;
        if (r == 0) return 1;
        long num = 1, den = 1;
        for (long i = 0; i < r; i++) {
            num = (num * (n - i)) % MOD;
            den = (den * (i + 1)) % MOD;
        }
        return (num * modInverse(den)) % MOD;
    }
    
    public int countGoodArrays(int n, int m, int k) {
        if (k >= n) return 0;
        
        //need to fill k positions -> given n-1 positions
        long kpos = nCr(n - 1, k);   

        //remaining (n-k-1) positions need to be filled with m-1 numbers (ie, (m-1)*(m-1)*....*(m-1) -> (n-k-1)times)
        long rem = power(m - 1, n - k - 1); 
        
        //0th index can be filled in m ways
        long ans = (kpos * m) % MOD;

        ans = (ans * rem) % MOD;            
        
        return (int)ans;
    }
}