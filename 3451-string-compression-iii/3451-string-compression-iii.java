class Solution {
    public String compressedString(String word) {
        int count = 1;
        int length = word.length();
        StringBuilder comp = new StringBuilder();
        
        for (int i = 1; i < length; i++) {
            if (word.charAt(i) == word.charAt(i - 1) && count < 9) {
                count++;
            } else {
                comp.append(count).append(word.charAt(i - 1));
                count = 1; 
            }
        }
        
        comp.append(count).append(word.charAt(length - 1));
        
        return comp.toString();
    }
}
