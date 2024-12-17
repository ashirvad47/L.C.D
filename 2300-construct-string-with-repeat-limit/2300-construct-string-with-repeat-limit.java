class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder res = new StringBuilder();
        int[] alpha = new int[26];
        for(char ch: s.toCharArray()){
            alpha[ch-'a']++;
        }
        char t = 'z';
        int val = 0;
        for(int i=25; i>=0; i--){
            if(alpha[i]>0){
                while(val>0 && alpha[i]>0){
                    res.append((char)('a'+i));
                    alpha[i]--;
                    for(int j=0; j<Math.min(repeatLimit, val); j++){
                        res.append(t);
                    }
                    val = val - Math.min(repeatLimit, val);
                }
                if(alpha[i]>0){
                    for(int j=0; j<Math.min(repeatLimit, alpha[i]); j++){
                        res.append((char)('a'+i));
                    }
                    alpha[i] = alpha[i] - Math.min(repeatLimit, alpha[i]);
                }
                if(alpha[i]>0){
                    t = (char)('a'+i);
                    val = alpha[i];
                }
            }
        }
        return res.toString();
    }
}