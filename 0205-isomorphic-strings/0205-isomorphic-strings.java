class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] mapS = new int[256]; // Maps characters in s to t
        int[] mapT = new int[256]; // Maps characters in t to s

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i); // Current character from s
            char charT = t.charAt(i); // Current character from t

            if (mapS[charS] != mapT[charT]) {
                return false; // Mappings don't match
            }

            mapS[charS] = i + 1; // Update mapping for s -> t
            mapT[charT] = i + 1; // Update mapping for t -> s
        }

        return true;
    }
}
