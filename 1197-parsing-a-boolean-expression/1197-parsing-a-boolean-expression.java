class Solution {
    public boolean parseBoolExpr(String expression) {
    Stack<Character> st = new Stack<>();
    for (int i = 0; i < expression.length(); i++) {
        char c = expression.charAt(i);
        if (c != ',') {
            if (c == ')') {
                Stack<Character> rand = new Stack<>();
                while (st.peek() != '(') {
                    rand.push(st.pop());
                }
                st.pop(); 
                char operator = st.pop();
                char result;
                if (operator == '&') {
                    result = parse_and(rand) ? 't' : 'f';
                } else if (operator == '|') {
                    result = parse_or(rand) ? 't' : 'f';
                } else {
                    result = parse_not(rand) ? 't' : 'f';
                }
                st.push(result);
            } else {
                st.push(c);
            }
        }
    }
    return st.pop() == 't';
}

    public boolean parse_or(Stack<Character> rand) {
        while (!rand.isEmpty()) { 
            char c = rand.pop();
            if (c == 't') { 
                return true;
            }
        }
        return false;
    }

    public boolean parse_and(Stack<Character> rand) {
        while (!rand.isEmpty()) { 
            char c = rand.pop();
            if (c == 'f') { 
                return false;
            }
        }
        return true;
    }

    public boolean parse_not(Stack<Character> rand) {
        char c = rand.pop(); 
        return c == 'f'; 
    }
}
