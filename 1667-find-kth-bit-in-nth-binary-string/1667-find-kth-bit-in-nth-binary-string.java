class Solution {
    public char findKthBit(int n, int k) {
        if (k == 1) {
            return '0';
        }
        return weirdSeq(n).charAt(k - 1);
    }

    private String weirdSeq(int n) {
        if (n == 1) {
            return "0";
        }
        String prev = weirdSeq(n - 1);
        return prev + "1" + invertAndReverse(prev);
    }

    private String invertAndReverse(String str) {
        StringBuilder sb = new StringBuilder(str).reverse();
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, sb.charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }
}