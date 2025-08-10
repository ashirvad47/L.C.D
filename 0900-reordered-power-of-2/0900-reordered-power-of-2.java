class Solution {
    private static Set<String> SORT_POWER_DIGITS = new HashSet<>();
    static {
        int power = 1;
        while (power <= 1_000_000_000) {            
            SORT_POWER_DIGITS.add(standardPowerString(power));
            power <<= 1;
        }
    }

    private static String standardPowerString(int n) {
        String s = Integer.toString(n);
        char[] sarr = s.toCharArray();
        Arrays.sort(sarr);
        return new String(sarr);
    }

    public boolean reorderedPowerOf2(int n) {
        return SORT_POWER_DIGITS.contains(standardPowerString(n));
    }
}