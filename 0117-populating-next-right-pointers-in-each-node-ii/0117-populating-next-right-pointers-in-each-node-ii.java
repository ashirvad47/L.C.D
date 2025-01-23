/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null; 

        Queue<Node> qu = new LinkedList<>();
        qu.offer(root);

        while (!qu.isEmpty()) {
            int levelSize = qu.size();
            while (levelSize != 0) {
                levelSize--;
                Node node = qu.poll();

                if (levelSize > 0) {
                    node.next = qu.peek();
                }
                if (node.left != null) {
                    qu.offer(node.left);
                }
                if (node.right != null) {
                    qu.offer(node.right);
                }
            }

        }

        return root;
    }
}
