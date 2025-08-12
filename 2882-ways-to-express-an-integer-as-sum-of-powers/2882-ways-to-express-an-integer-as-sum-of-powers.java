class Solution {
    HashMap<String , Integer> hm = new HashMap<>();
    static final int MOD = 1_000_000_007;
    public int numberOfWays(int n, int x) {
        return dfs(n , 1 , x);
    }

    public int dfs(int remaining , int current , int power)
    {
        if(remaining == 0)
        {
            return 1;
        }
        if((remaining < 0) || Math.pow(current , power) > remaining)
        {
            return 0;
        }
        
        String key = remaining + "," + current;
        if(hm.containsKey(key))
        {
            return hm.get(key);
        }
        int calc = (int)Math.pow(current , power);
        int take = dfs(remaining - calc , current + 1 , power);
        int not_take = dfs(remaining , current + 1 , power);

        int total = (take + not_take) % MOD;
        hm.put(key , total);
        return total;
    }
}