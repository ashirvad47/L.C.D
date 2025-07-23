class Solution {
    public int maximumGain(String s, int x, int y) {
        char firstL = x >= y ? 'a' : 'b';
        char firstR = x >= y ? 'b' : 'a';
        int firstScore = Math.max(x, y);
        char secondL = firstL == 'a' ? 'b' : 'a';
        char secondR = firstR == 'b' ? 'a' : 'b';
        int secondScore = Math.min(x, y);

        Deque<Character> stack1 = new ArrayDeque<>();
        int score = 0;
        for (char c : s.toCharArray()) {
            if (!stack1.isEmpty()
                    && stack1.peek() == firstL
                    && c == firstR) {
                stack1.pop();
                score += firstScore;
            } else {
                stack1.push(c);
            }
        }

        Deque<Character> stack2 = new ArrayDeque<>();
        while (!stack1.isEmpty()) {
            char c = stack1.pop();
            if (!stack2.isEmpty()
                    && stack2.peek() == secondR
                    && c == secondL) {
                stack2.pop();
                score += secondScore;
            } else {
                stack2.push(c);
            }
        }

        return score;
    }
}