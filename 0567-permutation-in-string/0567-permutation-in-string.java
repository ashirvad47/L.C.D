import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int len1 = s1.length();
        int len2 = s2.length();

        // If s1 is longer than s2, no permutation can exist
        if (len1 > len2) return false;

        HashMap<Character, Integer> map2 = new HashMap<>();
        
        // Initialize the first window
        for (int i = 0; i < len1; i++) {
            char c = s2.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        // Check if the first window matches
        if (map1.equals(map2)) return true;

        // Slide the window over s2
        for (int i = len1; i < len2; i++) {
            // Add the next character in the window
            char newChar = s2.charAt(i);
            map2.put(newChar, map2.getOrDefault(newChar, 0) + 1);

            // Remove the character that is left out of the window
            char oldChar = s2.charAt(i - len1);
            map2.put(oldChar, map2.get(oldChar) - 1);
            if (map2.get(oldChar) == 0) {
                map2.remove(oldChar);
            }

            // Check if the current window matches
            if (map1.equals(map2)) return true;
        }

        return false;
    }
}