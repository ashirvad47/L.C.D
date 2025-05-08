class Solution {
    public int minTimeToReach(int[][] moveTime) {
        //djisktra
        int m = moveTime.length;
        int n = moveTime[0].length;
        boolean[][] seen = new boolean[m][n];
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        pq.add(new int[]{0, 0, 0, 2});
        
        while(!pq.isEmpty()){
            int[] cur = pq.remove();
           // System.out.println(Arrays.toString(cur));
            if(cur[1] == m-1 && cur[2] == n-1) return cur[0];
            int cost =0;
            if(cur[3]==2) cost=1;
            else cost=2;
            
            for(int[] dir : dirs){
                int x = cur[1] + dir[0];
                int y = cur[2] + dir[1];
                if(x>=0 && y>=0 && x<m && y<n && !seen[x][y]){
                    seen[x][y] =true;
                    if(cur[0]>=moveTime[x][y]){
                        pq.add(new int[]{cur[0]+cost, x, y,cost});    
                    }else{
                        pq.add(new int[]{moveTime[x][y]+cost, x, y, cost});
                    }
                }
            }
        }
        return -1;
    }

}