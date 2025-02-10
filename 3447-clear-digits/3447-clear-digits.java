class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(char c :s.toCharArray()){
            if(c>='0' && c<='9') st.pop();
            else st.push(c);
        }

        for(char c : st) sb.append(c);

        return sb.toString();
    }
}