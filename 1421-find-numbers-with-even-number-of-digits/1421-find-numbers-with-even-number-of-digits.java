class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int i :nums) count+= Integer.toString(i).length()%2==0 ?  1:0;

        return count;
    }
}