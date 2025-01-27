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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int leftSum = Math.max(0, helper(root.left));  // Max sum from left subtree
        int rightSum = Math.max(0, helper(root.right)); // Max sum from right subtree

        // Update the global maxSum considering the path through the current node
        int currPathSum = leftSum + rightSum + root.val;
        maxSum = Math.max(maxSum, currPathSum);

        // Return the max sum that the current node can contribute to its parent
        return root.val + Math.max(leftSum, rightSum);
    }
}

