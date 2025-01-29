// Union Find
class Solution {
    
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        
        for(int i=0; i<parent.length; i++) {
            parent[i] = i;
        }
        
        for(int[] edge : edges) {
            if(find(edge[0]) == find(edge[1])) {
                return edge;
            }
            
            union(edge[0], edge[1]);
        }
        
        return new int[]{-1,-1};
    }
    
    
    // Find Operation
    private int find(int node) {
        while(parent[node] != node) {
            node = parent[node];
        }
        
        return node;
    }
    
    //Find Union Operation
    private void union(int i, int j) {
        int iRoot = find(i);
        int jRoot = find(j);
        
        if(iRoot != jRoot) {
            parent[jRoot] = iRoot;
        }
    }
}