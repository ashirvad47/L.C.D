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
        
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }
        
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    private int getLeftHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }
    
    private int getRightHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.right;
        }
        return height;
    }
}


//This optimized solution represents a significant improvement over the original approach by leveraging the special properties of complete binary trees. In a complete binary tree, all levels except possibly the last are entirely filled, and the last level has all nodes as far left as possible. This structure allows us to make a crucial optimization: when the left and right heights are equal, we know we're dealing with a perfect binary tree, where we can calculate the total number of nodes using the formula 2^h - 1 (implemented as `(1 << leftHeight) - 1` using bit manipulation for efficiency). The magic happens in how we navigate the tree - instead of blindly visiting every node like in the original O(n) solution, we first check if we're dealing with a perfect subtree. When we find a perfect subtree, we can instantly calculate its size without traversing its nodes. The algorithm only needs to recurse down the path where the tree might not be completely filled, which occurs at most O(log n) times. At each recursive step, we spend O(log n) time computing heights, leading to our overall time complexity of O(log^2 n). This becomes particularly powerful for large trees - imagine a complete binary tree with 1 million nodes: the original solution would need to visit all million nodes, while this optimized version would only need about 400 operations (log₂(1,000,000)² ≈ 20² ≈ 400). The space complexity remains O(log n) due to the recursion stack depth. This optimization showcases how understanding the underlying structure of a data structure can lead to dramatic performance improvements, even though the code itself remains relatively concise and elegant.
