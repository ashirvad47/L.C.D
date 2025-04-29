/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root.left == null && root.right == null)
            return root;

        int maxDepth = largestHeight(root)-1;

        return lcaDeepestLeaves(root, 0, maxDepth);

    }

    private TreeNode lcaDeepestLeaves(TreeNode node, int depth, int maxDepth) {
        if (node == null)
            return null;
        if (depth == maxDepth)
            return node;

        TreeNode L = lcaDeepestLeaves(node.left, depth + 1, maxDepth);
        TreeNode R = lcaDeepestLeaves(node.right, depth + 1, maxDepth);

        if (L != null && R != null)
            return node;
            
        else if (L==null) return R;
        else /*if(R==null)*/ return L;
    }

    public int largestHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(largestHeight(root.left), largestHeight(root.right));
    }

}