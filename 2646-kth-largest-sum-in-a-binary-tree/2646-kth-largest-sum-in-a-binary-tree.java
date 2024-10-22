/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        ArrayList<Long> arr = helper(root);

        if (arr.size() < k) {
            return -1;
        }

        Collections.sort(arr, Collections.reverseOrder());

        return arr.get(k - 1);
    }

    public ArrayList<Long> helper(TreeNode root) {
        ArrayList<Long> arr = new ArrayList<>();
        if (root == null) {
            return arr;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                sum += curr.val;

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            arr.add(sum);
        }

        return arr;
    }
}
