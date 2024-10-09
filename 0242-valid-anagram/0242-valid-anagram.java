class Solution {
    public boolean isAnagram(String s, String t) {
        char chs[] = s.toCharArray();
        char cht[] = t.toCharArray();

        Arrays.sort(chs);
        Arrays.sort(cht);

       if( Arrays.compare(chs,cht)==0) {
        return true;
       }else{
        return false;
       }


    }
}