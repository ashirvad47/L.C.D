class Solution {
    public char findKthBit(int n, int k) {
        if(k == 1){
            return '0';
        }
        char[] c = weirdSeq(n).toCharArray();

        return c[k - 1];
    }

    private String weirdSeq(int n){
        if(n == 1){
            return "0";
        }

        String prev = weirdSeq(n - 1);
        String invertAndReverse = inANDre(prev);
        return prev + "1" + invertAndReverse;
    }

    private String inANDre(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return sb.reverse().toString();
    }
}
