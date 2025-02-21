class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build the adjacency list representation of the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            graph.get(pair[1]).add(pair[0]); // Directed edge: bi → ai
        }

        // Step 2: Use DFS to detect cycles
        int[] visited = new int[numCourses]; // 0 = unvisited, 1 = visiting, 2 = visited

        for (int course = 0; course < numCourses; course++) {
            if (dfs(course, graph, visited)) {
                return false; // Cycle detected
            }
        }
        return true; // No cycles found
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> graph, int[] visited) {
        if (visited[course] == 1) return true;  // Cycle detected
        if (visited[course] == 2) return false; // Already checked, no cycle

        visited[course] = 1; // Mark as visiting
        for (int neighbor : graph.get(course)) {
            if (dfs(neighbor, graph, visited)) {
                return true; // Cycle detected
            }
        }
        visited[course] = 2; // Mark as visited
        return false;
    }
}
