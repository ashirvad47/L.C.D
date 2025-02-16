class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Step 1: Create a graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];
            
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            
            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }
        
        // Step 2: Process queries
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            results[i] = dfs(start, end, graph, new HashSet<>());
        }
        
        return results;
    }
    
    private double dfs(String start, String end, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1.0;
        }
        if (start.equals(end)) {
            return 1.0;
        }
        
        visited.add(start);
        
        for (Map.Entry<String, Double> neighbor : graph.get(start).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(neighbor.getKey(), end, graph, visited);
                if (result != -1.0) {
                    return result * neighbor.getValue();
                }
            }
        }
        
        return -1.0;
    }
}
