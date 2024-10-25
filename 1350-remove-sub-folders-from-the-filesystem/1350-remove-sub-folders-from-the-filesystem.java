class Solution {
    static class Node {
        Node[] children = new Node[27];
        boolean isEnd;
        Node() {
            Arrays.fill(children, null);
            isEnd = false;
        }
    }
    
    Node root = new Node();
    public List<String> removeSubfolders(String[] folder) {
        root = new Node(); // Reset root
        
        // Insert all folders
        for (String path : folder) {
            Node curr = root;
            for (String dir : path.split("/")) {
                if (dir.isEmpty()) continue;
                
                // Process each character in the directory name
                Node next = null;
                for (char c : dir.toCharArray()) {
                    int idx = c - 'a';
                    if (curr.children[idx] == null) {
                        curr.children[idx] = new Node();
                    }
                    curr = curr.children[idx];
                }
                
                // Mark the end of directory name with special character
                if (curr.children[26] == null) {
                    curr.children[26] = new Node();
                }
                curr = curr.children[26];
            }
            curr.isEnd = true;
        }
        
        // Check for valid folders
        List<String> res = new ArrayList<>();
        for (String path : folder) {
            Node curr = root;
            boolean isValid = true;
            
            for (String dir : path.split("/")) {
                if (dir.isEmpty()) continue;
                
                if (curr.isEnd) {
                    isValid = false;
                    break;
                }
                
                // Navigate through each character
                for (char c : dir.toCharArray()) {
                    int idx =c - 'a';
                    curr = curr.children[idx];
                }
                // Move to end of directory marker
                curr = curr.children[26];
            }
            
            if (isValid) {
                res.add(path);
            }
        }
        
        return res;
    }
}