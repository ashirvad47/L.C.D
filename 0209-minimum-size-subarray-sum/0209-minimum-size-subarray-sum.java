class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // HashMap<Integer,Integer> map = new HashMap<>();

        // for(int i :nums){
        //     map.put(i,map.getOrDefault(i,0)+1);
        // }

        int sum=0;
        int len=Integer.MAX_VALUE;
        for(int i = 0,j=0; i<nums.length;i++){
            sum+=nums[i];
            if(sum>=target){
                len = Math.min(len, i-j+1);
                j +=1;
                i=j-1;
                sum=0;
            }
        }
        return len < Integer.MAX_VALUE ? len:0;
    }
}