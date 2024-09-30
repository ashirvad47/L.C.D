class Solution {
    public int lengthOfLastWord(String s) {
        // Trim any trailing spaces
        s = s.trim();
        
        // Start from the last character and find the start of the last word
        int length = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            length++;
        }
        
        return length;
    }
}
