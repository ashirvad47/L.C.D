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
//     List<Integer> ls = new ArrayList<>();
//     public boolean isValidBST(TreeNode root) {
//         helper(root);

//         for(int i =0; i < ls.size()-1;i++){
//             if(ls.get(i)>=ls.get(i+1)) return false;
//         }

//         return true;
//     }

//     private void helper(TreeNode root){
//         if(root==null) return;

//         helper(root.left);
//         ls.add(root.val);
//         helper(root.right);
//     }
// }

// faster one 
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;
        
        if ((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;
        
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}