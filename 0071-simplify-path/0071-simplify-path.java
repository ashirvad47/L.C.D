class Solution {
    public String simplifyPath(String path) {
        String[] str = path.split("/");

        List<String> result = new ArrayList<>();

        for (String s : str) {
            if (s.equals("") || s.equals(".")) {
                // Skip empty parts and current directory references
                continue;
            }

            if (s.equals("..")) {
                // Pop the last directory if possible
                if (!result.isEmpty()) {
                    result.remove(result.size() - 1);
                }
            } else {
                // Add valid directory to the result
                result.add(s);
            }
        }

        // Build the simplified path by joining the list elements
        return "/" + String.join("/", result);
    }
}
