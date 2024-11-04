class Solution {
    public String compressedString(String word) {
        int count =1;
        String comp ="";
        for(int i =1;i<word.length();i++){
            if(word.charAt(i)==word.charAt(i-1) && count<9){count ++;} 
            else{
                comp = comp +  count + word.charAt(i-1);
                count =1;
            }
        }
        comp = comp+ count +word.charAt(word.length()-1);
        return comp;
    }
}