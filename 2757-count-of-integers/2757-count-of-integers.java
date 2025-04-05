class Solution {
    private static final int MOD = 1_000_000_007;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        int count2 = countUpTo(num2, min_sum, max_sum);

        int count1 = countUpTo(decrementString(num1), min_sum, max_sum);

        return (count2 - count1 + MOD) % MOD;
    }

    private String decrementString(String num) {
        if (num.equals("1"))
            return "0";

        char[] chars = num.toCharArray();
        int i = chars.length - 1;

        while (i >= 0 && chars[i] == '0') {
            chars[i] = '9';
            i--;
        }

        chars[i] = (char) (chars[i] - 1);
        return new String(chars);
    }

    private int countUpTo(String num, int min_sum, int max_sum) {
        int n = num.length();

        long[][] current = new long[max_sum + 1][2];
        long[][] next = new long[max_sum + 1][2];

        current[0][1] = 1;

        for (int pos = 0; pos < n; pos++) {
            int limit = num.charAt(pos) - '0';

            for (int sum = 0; sum <= max_sum; sum++) {
                next[sum][0] = 0;
                next[sum][1] = 0;
            }

            for (int prevSum = 0; prevSum <= max_sum; prevSum++) {
                // For not tight constraint
                if (current[prevSum][0] > 0) {
                    for (int digit = 0; digit <= 9; digit++) {
                        int newSum = prevSum + digit;
                        if (newSum <= max_sum) {
                            next[newSum][0] = (next[newSum][0] + current[prevSum][0]) % MOD;
                        }
                    }
                }

                // For tight constraint
                if (current[prevSum][1] > 0) {
                    for (int digit = 0; digit < limit; digit++) {
                        int newSum = prevSum + digit;
                        if (newSum <= max_sum) {
                            next[newSum][0] = (next[newSum][0] + current[prevSum][1]) % MOD;
                        }
                    }

                    // For the limiting digit
                    int newSum = prevSum + limit;
                    if (newSum <= max_sum) {
                        next[newSum][1] = (next[newSum][1] + current[prevSum][1]) % MOD;
                    }
                }
            }

            // Swap current and next for the next iteration
            long[][] temp = current;
            current = next;
            next = temp;
        }

        // Sum up all valid results
        long result = 0;
        for (int sum = min_sum; sum <= max_sum; sum++) {
            result = (result + current[sum][0] + current[sum][1]) % MOD;
        }

        return (int) result;
    }

    public int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x = x / 10;
        }
        return sum;
    }
}


//learn digit dp properly before solving this again