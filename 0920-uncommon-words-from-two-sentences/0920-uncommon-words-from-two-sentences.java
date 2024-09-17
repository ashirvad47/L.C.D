import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {

        HashMap<String, Integer> map = new HashMap<>();
       
        String s = s1 + " " + s2;
        String[] words = s.split(" ");
        
        for (String i : words) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        
        return result.toArray(new String[0]);
    }
}
