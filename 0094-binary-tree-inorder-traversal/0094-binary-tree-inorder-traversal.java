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
    List<Integer> ls = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);

        return ls;
    }

    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        ls.add(root.val);
        helper(root.right);

    }
}