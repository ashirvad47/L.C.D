class Solution {
    public int differenceOfSums(int n, int m) {
        int total = n * (n + 1)/ 2;
        int notDivisible = n * (n + 1)/ 2;
        int i = 1;
        int multiplesOfM = m;
        while(multiplesOfM <= n) {
            notDivisible -= multiplesOfM;
            i++;
            multiplesOfM = m * i;
        }
        int divisible = total - notDivisible;
        return notDivisible - divisible;
    }
}