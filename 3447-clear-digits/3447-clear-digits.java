class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> st = new ArrayDeque<>();

        for(char c :s.toCharArray()){
            if(c>='0' && c<='9') st.pop();
            else st.push(c);
        }

        for(char c : st) sb.append(c);

        return sb.reverse().toString();
    }
}