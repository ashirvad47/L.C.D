class Solution {
    public boolean isPowerOfThree(int n) {
        int maxpower=1162261467;
        return n>0 && maxpower%n==0;
    }
}