class Solution {
    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        char[] str = new char[s.length()];
        int wriDex = 0;
        for (int i = 25; i >= 0; i--) {
            for (int j = 0; j < counts[i]; j++) {
                str[wriDex++] = (char) (i + 'a');
            }
        }
        int rep = 0;
        char cur = str[0];
        int next = 1;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == cur) {
                rep++;
                if (rep == repeatLimit + 1) {
                    if (next < i) next = i + 1;
                    while (next < str.length && str[next] >= cur) next++;
                    if (next == str.length) return String.valueOf(str, 0, i);
                    char tmp = str[i];
                    str[i] = str[next];
                    str[next] = tmp;
                    rep = 0;
                }
            } else {
                cur = str[i];
                rep = 1;
            }
        }
        return String.valueOf(str);
    }
}