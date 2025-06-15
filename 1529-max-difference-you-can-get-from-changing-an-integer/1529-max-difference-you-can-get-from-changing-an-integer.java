class Solution {
    public int maxDiff(int num) {

        int firstdigit = -1, firstnonnine = -1;
        int remain = num;
        int replacingdigit = 1;

        while (remain > 0) {
            int digit = remain % 10;

            if (digit > 1) {
                firstdigit = digit;
                replacingdigit = 1;
            } else
                replacingdigit = 0;

            if (digit != 9) {
                firstnonnine = digit;
            }

            remain = remain / 10;
        }

        int max = 0, min = 0;
        int mul = 1;
        remain = num;

        while (remain > 0) {
            int digit = remain % 10;

            if (digit == firstnonnine) {
                max = max + (9 * mul);
            } else
                max = max + (digit * mul);

            if (digit == firstdigit) {
                min = min + (replacingdigit * mul);
            } else
                min = min + (digit * mul);

            mul = mul * 10;
            remain = remain / 10;
        }
        return max - min;
    }
}