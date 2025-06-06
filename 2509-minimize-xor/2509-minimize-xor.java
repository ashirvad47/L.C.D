class Solution {
        public int minimizeXor(int num1, int num2) {
        int a = Integer.bitCount(num1), b = Integer.bitCount(num2), res = num1;
        for (int i = 0; i < 32; i++) {
            if (a > b && ((1 << i) & num1) > 0) {//DROP BIT
                res ^= 1 << i;
                a--;
            }
            if (a < b && ((1 << i) & num1) == 0) {//SET BIT
                res ^= 1 << i;
                a++;
            }
        }
        return res;
    }
}