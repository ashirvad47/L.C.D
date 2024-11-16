// class Solution {
//     public boolean canConstruct(String ransomNote, String magazine) {
//         HashMap<Character,Integer> map = new HashMap<>();

//         for(char i :  magazine.toCharArray()){
//             map.put(i,map.getOrDefault(i,0)+1);
//         }
//         for(char i : ransomNote.toCharArray()){
//             if(map.containsKey(i) && map.get(i)>0){
//                 map.put(i,map.get(i)-1);
//             }
//             else return false;
//         }
//         return true;
//     }
// }
//without hashmap
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) return false;
        int[] alphabets_counter = new int[26];
        
        for (char c : magazine.toCharArray())
            alphabets_counter[c-'a']++;

        for (char c : ransomNote.toCharArray()){
            if (alphabets_counter[c-'a'] == 0) return false;
            alphabets_counter[c-'a']--;
        }
        return true;
    }
}