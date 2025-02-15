class Solution {
    private boolean isValidPartition(int num, int square, int sum, int index) {
        if (index == String.valueOf(square).length()) {
            return sum == num;
        }
        
        int currentSum = 0;
        String squareStr = String.valueOf(square);
        
        for (int i = index; i < squareStr.length(); i++) {
            currentSum = currentSum * 10 + (squareStr.charAt(i) - '0');
            if (isValidPartition(num, square, sum + currentSum, i + 1)) {
                return true;
            }
        }
        return false;
    }

    public int punishmentNumber(int n) {
        int punishmentSum = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 9 != 0 && i % 9 != 1) continue;

            int square = i * i;
            if (isValidPartition(i, square, 0, 0)) {
                punishmentSum += square;
            }
        }
        return punishmentSum;
    }
}
