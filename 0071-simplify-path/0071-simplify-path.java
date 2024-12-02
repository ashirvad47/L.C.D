class Solution {
    public String simplifyPath(String path) {
        String[] str = path.split("/");

        Deque<String> deque = new ArrayDeque<>();

        for (String s : str) {
            if (s.equals("") || s.equals(".")) {
                // Skip empty parts and current directory references
                continue;
            }

            if (s.equals("..")) {
                // Pop the last directory if possible
                if (!deque.isEmpty()) {
                    deque.pollLast(); // Remove from the end (equivalent to stack pop)
                }
            } else {
                // Add valid directory to the deque
                deque.offerLast(s); // Add to the end (equivalent to stack push)
            }
        }

        // Build the simplified path by joining the deque elements
        return "/" + String.join("/", deque);
    }
}
