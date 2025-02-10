// class Solution {
//     public String clearDigits(String s) {
//         StringBuilder sb = new StringBuilder();
//         Deque<Character> st = new ArrayDeque<>();

//         for(char c :s.toCharArray()){
//             if(c>='0' && c<='9') st.pop();
//             else st.push(c);
//         }

//         for(char c : st) sb.append(c);

//         return sb.reverse().toString();
//     }
// }

class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (sb.length() > 0) sb.setLength(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
