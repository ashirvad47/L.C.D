class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
       int j =0;
        for(int i : spaces){
            sb.append(s.substring(j,i));
            sb.append(" ");
            j=i;
        }
        sb.append(s.substring(j));



        return sb.toString();
    }
}