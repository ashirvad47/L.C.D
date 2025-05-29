class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        List<List<Integer>> adj1 = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();

        for (int[] edge : edges1) {
            while (adj1.size() <= edge[0]) {
                adj1.add(new ArrayList<>());
            }
            while (adj1.size() <= edge[1]) {
                adj1.add(new ArrayList<>());
            }

            adj1.get(edge[0]).add(edge[1]);
            adj1.get(edge[1]).add(edge[0]);
        }

        for (int[] edge : edges2) {
            while (adj2.size() <= edge[0]) {
                adj2.add(new ArrayList<>());
            }
            while (adj2.size() <= edge[1]) {
                adj2.add(new ArrayList<>());
            }

            adj2.get(edge[0]).add(edge[1]);
            adj2.get(edge[1]).add(edge[0]);
        }

        int[] path1 = new int[adj1.size()];
        int[] path2 = new int[adj2.size()];

        Arrays.fill(path1, -1);
        Arrays.fill(path2, -1);

        int[] countNodesInPath1 = new int[2];
        int[] countNodesInPath2 = new int[2];

        markPathToNodesAndCountNodes(adj1, 0, 0, path1, countNodesInPath1);
        markPathToNodesAndCountNodes(adj2, 0, 0, path2, countNodesInPath2);

        int maxFromTree2 = Math.max(countNodesInPath2[0], countNodesInPath2[1]);

        int[] ans = new int[adj1.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = maxFromTree2 + countNodesInPath1[path1[i]];
        }

        return ans;
    }

    public void markPathToNodesAndCountNodes(List<List<Integer>> adj, int node, int curr, int[] path, int[] count) {
        if (path[node] != -1)
            return;

        path[node] = curr;
        count[curr] += 1;

        for (int nei : adj.get(node)) {
            markPathToNodesAndCountNodes(adj, nei, curr ^ 1, path, count);
        }

    }
}