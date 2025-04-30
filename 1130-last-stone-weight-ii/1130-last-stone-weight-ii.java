// class Solution {
//     public int lastStoneWeightII(int[] stones) {
//         int sum = 0;

//         for (int i : stones)
//             sum += i;

//         boolean dp[][] = new boolean[stones.length + 1][sum + 1];
//         for (int i = 0; i < stones.length + 1; i++)
//             dp[i][0] = true;
//         for (int i = 1; i < stones.length + 1; i++)
//             for (int j = 1; j <= sum / 2; j++) {
//                 if (stones[i - 1] <= j)
//                     dp[i][j] = dp[i - 1][j - stones[i - 1]] || dp[i - 1][j];
//                 else
//                     dp[i][j] = dp[i - 1][j];
//             }

//         // int res= Integer.MAX_VALUE;
//         for (int i = sum / 2; i >= 0; i--) {
//             if (dp[stones.length][i]) {
//                 return sum - 2 * i;
//             }
//         }
//         return 0;
//     }
// }

// class Solution {
//     public int lastStoneWeightII(int[] stones) {
//         int n = stones.length, sum = 0;
//         for (int w : stones)
//             sum += w;
//         int half = sum / 2;

//         boolean[] dp = new boolean[half + 1];
//         dp[0] = true;

//         for (int w : stones) {
//             for (int j = half; j >= w; j--) {
//                 dp[j] = dp[j] || dp[j - w];
//             }
//         }

//         for (int j = half; j >= 0; j--) {
//             if (dp[j]) {
//                 return sum - 2 * j;
//             }
//         }
//         return 0;
//     }
// }

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        
        boolean[][] memo = new boolean[stones.length + 1][sum + 1];
        
        for (int i = 0; i <= stones.length; i++) {
            memo[i][0] = true;
        }
        
        for (int i = sum / 2; i >= 0; i--) {
            if (canMakeSum(stones, stones.length, i, memo)) {
                return sum - 2 * i;
            }
        }
        
        return 0;
    }
    
    private boolean canMakeSum(int[] stones, int i, int j, boolean[][] memo) {
        if (j == 0) return true;
        if (i == 0) return false;
        
        if (memo[i][j]) {
            return true;
        }
        
        
        if (stones[i-1] <= j) {
            memo[i][j] = canMakeSum(stones, i-1, j - stones[i-1], memo) || 
                    canMakeSum(stones, i-1, j, memo);
        } else {
            memo[i][j] = canMakeSum(stones, i-1, j, memo);
        }
        
        return memo[i][j];
    }
}