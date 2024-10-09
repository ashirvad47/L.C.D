// class Solution {
//     public boolean isAnagram(String s, String t) {
//         char chs[] = s.toCharArray();
//         char cht[] = t.toCharArray();

//         Arrays.sort(chs);
//         Arrays.sort(cht);

//        if( Arrays.compare(chs,cht)==0) {
//         return true;
//        }else{
//         return false;
//        }


//     }
// }

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char i : s.toCharArray()) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (char i : t.toCharArray()) {
            map.put(i, map.getOrDefault(i, 0) - 1);
        }
        for (char i : map.keySet()) {
            if (map.get(i) != 0) {
                return false;
            }
        }
        return true;
    }
}