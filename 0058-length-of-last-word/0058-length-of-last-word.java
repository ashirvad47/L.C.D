class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        
        int length = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                length = s.length()-1-i;
                break;
            }
        }
        if (length == 0) { 
            length = s.length();
        }
        
        return length;
    }
}