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
// class Solution {
//     public int countNodes(TreeNode root) {
//         if(root==null) return 0;

//         return countNodes(root.left) + countNodes(root.right) + 1;
//     }
// }

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        // Get heights of left and right subtrees
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        
        // If heights are equal, we have a perfect binary tree
        if (leftHeight == rightHeight) {
            // A perfect binary tree of height h has 2^h - 1 nodes
            return (1 << leftHeight) - 1;
        }
        
        // If heights differ, recursively count nodes
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    // Gets height going only left
    private int getLeftHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }
    
    // Gets height going only right
    private int getRightHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.right;
        }
        return height;
    }
}


