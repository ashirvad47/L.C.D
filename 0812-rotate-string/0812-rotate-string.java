class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            String str = goal.substring(i) + goal.substring(0, i);
            if (s.equals(str))
                return true;
        }
        return false;
    }
}
