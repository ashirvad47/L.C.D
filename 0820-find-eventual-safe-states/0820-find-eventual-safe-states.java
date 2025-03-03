class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if (graph == null || graph.length == 0)
            return res;

        int nodeCount = graph.length;
        int[] color = new int[nodeCount];

        for (int i = 0; i < nodeCount; i++) {
            if (dfs(graph, i, color))
                res.add(i);
        }

        return res;
    }

    public boolean dfs(int[][] graph, int start, int[] color) {
        if (color[start] == 1)
            return true;
        if (color[start] == 2)
            return false;
        color[start] = 2;
        for (int newNode : graph[start]) {
            if (dfs(graph, newNode, color) == false)
                return false;
        }
        color[start] = 1;

        return true;
    }
}