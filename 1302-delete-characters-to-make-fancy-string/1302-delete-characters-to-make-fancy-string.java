class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder();
        char[] carr = s.toCharArray();
       
        int count = 1;
        for (int i = 0; i < carr.length; i++) {
            if (i > 0 && carr[i] == carr[i - 1]) {
                count++;
            } else {
                count = 1; 
            }
            if (count < 3) {
                str.append(carr[i]);
            }
        }
        
        return str.toString();
    }
}