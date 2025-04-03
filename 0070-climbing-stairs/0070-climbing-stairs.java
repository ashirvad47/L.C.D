//Dynamic Programming

// class Solution {
//     public int climbStairs(int n) {

//         if (n == 1)
//             return 1;
//         if (n == 2)
//             return 2;

//         int dp[] = new int[n + 1];
//         dp[1] = 1;
//         dp[2] = 2;
//         for (int i = 3; i <= n; i++) {
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }
//         return dp[n];
//     }
// }

// Without DP
class Solution {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

        for (int i = 3; i <= n; i++) {
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }

        return all_ways;
    }
}
/*
 * So the "all_ways" corresponds to the number of solutions to get to the point [n].
 * And "one_step_before" refers to the number of solutions until the point [n-1],
 * "two_steps_before" refers to the number of solution until the point [n-2].
 * 
 * From the point [n-1], we take one step to reach the point [n].
 * From the point [n-2], we take a two-steps leap to reach the point [n].
 * 
 * So it goes without saying that the total number of solution to reach the
 * point [n] should be [n-1] + [n-2].
 */
