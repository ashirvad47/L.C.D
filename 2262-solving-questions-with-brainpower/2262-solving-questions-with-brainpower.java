class Solution {// i points, j brainpower
    public long mostPoints(int[][] questions) {
        long dp [] = new long[questions.length+1];

        for(int i = questions.length-1; i >=0;i--){
            int points = questions[i][0];
            int skip = questions[i][1];

            long solve = points + (i+skip+1 < questions.length ? dp[i+skip+1] :0);
            long notSolve = dp[i+1];

            dp [i] = Math.max(solve,notSolve);
        }

        return dp[0];
         
    }
}