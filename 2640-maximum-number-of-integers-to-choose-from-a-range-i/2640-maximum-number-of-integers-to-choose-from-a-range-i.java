class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set < Integer> set = new HashSet<>();
        
        for(int i : banned){
            if( i <= n){
                set.add(i);
            }
        }
        int count =0;
        int sum=0;
        for(int i =1; i<=n;i++){
            if(!set.contains(i) && sum<= maxSum) {
                sum+=i;
                if(sum<= maxSum) count++;
            }

        }

        return count;

    }
}