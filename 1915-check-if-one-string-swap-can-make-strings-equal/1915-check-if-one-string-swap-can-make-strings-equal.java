class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        if (s1.length() != s2.length())
            return false;
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        int count = 0;
        int temp[] = new int[4];
        int j = 0;

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                count++;
                if (count <= 2) {
                    temp[j++] = c1[i];
                    temp[j++] = c2[i];
                }else return false;

            }
        }
        if (count == 2) {
            if (temp[0] == temp[3] && temp[1] == temp[2])
                return true;
        }

        return false;

    }
}