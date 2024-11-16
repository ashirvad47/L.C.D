class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();
     
        char [] rans = ransomNote.toCharArray();
        char [] mag = magazine.toCharArray();

        for(char i : mag){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(char i : rans){
            if(map.containsKey(i) && map.get(i)>0){
                map.put(i,map.get(i)-1);
            }
            else return false;
        }
        return true;
    }
}