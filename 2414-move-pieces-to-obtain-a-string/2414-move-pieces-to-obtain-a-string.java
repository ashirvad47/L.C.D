import java.util.HashMap;

class Solution {
    public boolean canChange(String start, String target) {
        if (start.length() != target.length())
            return false;

        HashMap<Character, Integer> startFreq = new HashMap<>();
        HashMap<Character, Integer> targetFreq = new HashMap<>();

        for (char ch : start.toCharArray())
            startFreq.put(ch, startFreq.getOrDefault(ch, 0) + 1);

        for (char ch : target.toCharArray())
            targetFreq.put(ch, targetFreq.getOrDefault(ch, 0) + 1);

        if (!startFreq.equals(targetFreq))
            return false;

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

        return true;
    }
}
