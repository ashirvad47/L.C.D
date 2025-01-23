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
        qu.offer(null);

        while (!qu.isEmpty()) {
            Node currentNode = qu.poll();

            if (currentNode != null) {
                currentNode.next = qu.peek();

                if (currentNode.left != null) qu.offer(currentNode.left);
                if (currentNode.right != null) qu.offer(currentNode.right);
            } else {
                if (!qu.isEmpty()) {
                    qu.offer(null); 
                }
            }
        }

        return root;
    }
}
