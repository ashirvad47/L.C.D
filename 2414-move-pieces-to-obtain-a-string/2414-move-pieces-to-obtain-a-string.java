class Solution {
    public boolean canChange(String start, String target) {
        char[] startArr = start.toCharArray();
        char[] targetArr = target.toCharArray();
        int i = 0, j = 0;

        while (i <= startArr.length && j <= targetArr.length) {
            while (i < startArr.length && startArr[i] == '_') i++;
            while (j < targetArr.length && targetArr[j] == '_') j++;

            if (i == startArr.length || j == targetArr.length)
                return i == startArr.length && j == targetArr.length;

            if (startArr[i] != targetArr[j]) return false;

            if (startArr[i] == 'L' && i < j) return false;
            if (startArr[i] == 'R' && i > j) return false;

            i++;
            j++;
        }

        return true;
    }
}
