class Node {
    Node[] children = new Node[26];
    boolean eow;
    Node() {
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
        eow = false;
    }
}

class Trie {
    Node root = new Node();; 

    // public Trie() {
    //     root = new Node();
    // }

    public void insert(String word) {
        Node current = root; 
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (current.children[idx] == null) {
                current.children[idx] = new Node();
            }
            current = current.children[idx];
        }
        current.eow = true; 
    }

    public boolean search(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (current.children[idx] == null) {
                return false; 
            }
            if (i == word.length() - 1 && current.children[idx].eow == false) {
                return false;
            }
            current = current.children[idx];
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (current.children[idx] == null) {
                return false;
            }
            current = current.children[idx];
        }
        return true; 
    }
}