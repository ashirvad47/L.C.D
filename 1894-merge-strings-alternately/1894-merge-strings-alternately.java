class Solution {
    public String mergeAlternately(String word1, String word2) {
        char w1 [] = word1.toCharArray();
        char w2 [] = word2.toCharArray();

        int n = word1.length() >= word2.length() ? word1.length() : word2.length();
        StringBuilder sb = new StringBuilder();
        for (int i =0; i < n;i++){
            if(i<w1.length) sb.append(w1[i]);
            if(i<w2.length) sb.append(w2[i]);

        }

        return sb.toString();
    }
}