class Solution {
    public boolean splitString(String s) {
        return helper(s,0,-1,0);
    }

    private boolean helper(String s, int idx, long prev, int count){
        if(idx >= s.length()) {
            if(count>=2)return true;
            else return false;
        }
        long curr =0;
        for(int i =idx;i < s.length();i++){
            curr = curr*10 + (s.charAt(i)-'0');
            if(prev==-1 || (prev-curr)==1) if (helper(s,i+1,curr,count+1))return true;
        }

        return  false;

    }
}