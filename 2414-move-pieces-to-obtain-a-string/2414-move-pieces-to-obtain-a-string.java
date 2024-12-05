class Solution {
    public boolean canChange(String start, String target) {
        int i = 0, j = 0;

        while (i < start.length() && j < target.length()) {
            while (i < start.length() && start.charAt(i) == '_')
                i++;
            while (j < target.length() && target.charAt(j) == '_')
                j++;

            if (i == start.length() || j == target.length())
                break;

            if (start.charAt(i) != target.charAt(j)) {
                return false;
            } else {
                if (start.charAt(i) == 'L' && i < j)
                    return false;
                if (start.charAt(i) == 'R' && i > j)
                    return false;

                i++;
                j++;
            }

        }

        while (i < start.length() && start.charAt(i) == '_')
            i++;
        while (j < target.length() && target.charAt(j) == '_')
            j++;

        return i == start.length() && j == target.length();
    }
}
