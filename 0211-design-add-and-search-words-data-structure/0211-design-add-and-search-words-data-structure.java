public class Node{
    Node children[]= new Node[26];
    boolean eow;

    Node(){
        Arrays.fill(children,null);
        eow=false;
    }
}

class WordDictionary {
    Node root;
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node current = root;
       for(int i =0; i <word.length();i++){
            int idx= word.charAt(i)-'a';

            if(current.children[idx]==null){
                current.children[idx]= new Node();
            }
            current= current.children[idx];
       }
       current.eow= true; 
    }
    
    public boolean search(String word) {
    return searchInNode(word, root);
}

    private boolean searchInNode(String word, Node current) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            // Case when we encounter a dot '.'
            if (c == '.') {
                // Try every possible child node (i.e., every letter from 'a' to 'z')
             for (int j = 0; j < 26; j++) {
                    if (current.children[j] != null) {
                       // Check the remaining part of the word with the current child node 
                        if (searchInNode(word.substring(i + 1), current.children[j])) {
                            return true;  // If we find a valid path for any child, return true
                        }
                    }
            }
                return false;  // No valid path found for the dot
            }

            int idx = c - 'a';

            if (current.children[idx] == null) {
                return false;  // If the current character path doesn't exist, return false
            }

        // Check if it's the last character of the word
            if (i == word.length() - 1 && !current.children[idx].eow) {
                return false;  // If this is the last character but not an end of a word, return false
            }
        
            current = current.children[idx];  // Move to the next node
        }

     // After finishing the loop, we need to check if we're at a valid end of a word
        return current.eow;  // Return true if this node marks the end of a word
    }


}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */