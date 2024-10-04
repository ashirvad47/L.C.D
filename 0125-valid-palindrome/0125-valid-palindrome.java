class Solution {
    public boolean isPalindrome(String s) {
        s= s.toLowerCase();
        char ch[] =s.toCharArray();
        int count=0;
        for (int i =0; i<ch.length;i++){
            if(ch[i]>=97 && ch[i]<=122 || ch[i]>=48 && ch[i]<=57){
                ch[count]= ch[i];
                count++;
            }
        }
        boolean flag= true;
        for(int i=0; i < count/2;i++){
            if(ch[i]!=ch[count-1-i]){
                flag= false;
                break;
            }
        }

        return flag;

        
    }
}