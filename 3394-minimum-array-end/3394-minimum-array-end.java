class Solution {
    public long minEnd(int n, int x) {
        long a = x;
        while (n-- > 1)
            a = (a + 1) | x;
        return a;
    }
}