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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root.left==null && root.right==null || root==null) return root;
        int maxDepth = maxHeight(root)-1;

        return subtreeWithAllDeepest(root, 0, maxDepth);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root,int depth, int maxDepth){
        if(root==null) return root;

        if(depth==maxDepth) return root;

        TreeNode Left = subtreeWithAllDeepest(root.left,depth+1,maxDepth);
        TreeNode Right = subtreeWithAllDeepest(root.right,depth+1,maxDepth);

        if(Left!=null && Right !=null) return root;

        if(Left == null) return Right;
        else return Left;
    }

    public int maxHeight(TreeNode root){
        if(root==null) return 0;

        return 1 + Math.max( maxHeight(root.left), maxHeight( root.right));
    }
}