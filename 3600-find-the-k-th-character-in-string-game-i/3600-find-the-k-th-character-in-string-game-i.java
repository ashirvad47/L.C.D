class Solution {
    public char kthCharacter(int k) {
        String fin = "a";

        while(fin.length()<k){
            String res="";
            for(char c: fin.toCharArray()){
                if(c!='z') c+=1;
                else c='a';
                res +=c;
            }
            // System.out.println(res);
            fin +=res;
        }
        // System.out.println(fin);
        return fin.charAt(k-1);
    }
}