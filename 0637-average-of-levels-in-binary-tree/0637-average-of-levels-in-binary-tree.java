class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        List<Double> ls = new ArrayList<>();
        
        qu.add(root);
        qu.add(null);
        int count = 0;
        double sum = 0;
        
        while (!qu.isEmpty()) {
            TreeNode curr = qu.poll();
            
            if (curr == null) {
                Double d = (double) sum/count;
                ls.add(d);
                sum = 0;
                count = 0;
                
                if (!qu.isEmpty()) {
                    qu.offer(null);
                }
            } else {
                sum += curr.val;
                count++;
                if (curr.left != null) {
                    qu.offer(curr.left);
                }
                if (curr.right != null) {
                    qu.offer(curr.right);
                }
            }
        }
        
        return ls;
    }
}