class Solution {
    public String simplifyPath(String path) {
        String[] str = path.split("/");

        Stack<String> st = new Stack<>();

        for (String s : str) {
            // Skip consecutive "/" or "."
            if ( ((!st.isEmpty() && st.peek().equals("/")) && s.equals("/") ) || s.equals(".")) continue;
            // Handle ".."
            if (s.equals("..")) {
                if (!st.isEmpty()) st.pop(); // Pop once for the previous directory
            } else if (!s.equals("")) {
                // Push valid directory names
                st.push(s);
            }
        }

        // Join the stack content to build the result
        return "/" + String.join("/", st);
    }
}
