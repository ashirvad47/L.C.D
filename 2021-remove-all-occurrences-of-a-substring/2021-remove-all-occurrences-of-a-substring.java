class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);

        return helper(sb,part).toString();

    }

    private StringBuilder helper(StringBuilder sb , String part){
        if(sb.indexOf(part)==-1) return sb;

        int ind = sb.indexOf(part);

        return helper(sb.delete(ind,ind+ part.length()),part);
        
    }
}