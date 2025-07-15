class Solution {
    public boolean isValid(String word) {
        if(word.length()<3) return false;
        int vow=0;
        int con=0;

        for(char c: word.toCharArray()){
            if(c=='a' || c=='e' ||c=='i' ||c=='o' ||c=='u' || c=='A' || c=='E' ||c=='I' ||c=='O' ||c=='U') vow++;
            else if((c>='A'&&c<='Z')||(c>='a'&&c<='z')) con++;
            else if(c>='0' && c<='9') continue;
            else return false;


        }

        return (con>0 && vow >0);
    }
}