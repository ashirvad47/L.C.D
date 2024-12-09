class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int[] ps = new int[nums.length];//ps-> prefix sum
        for(int i=1;i<nums.length;i++){
            ps[i] = ps[i-1];
            if(nums[i-1]%2 == nums[i]%2){
                ps[i]++;
            }
        }
        for(int i=0;i<queries.length;i++){
            if(ps[queries[i][1]]-ps[queries[i][0]]==0) {
                ans[i]=true;
            }else{
                ans[i]=false;
            }
        }
        return ans;
    }
}