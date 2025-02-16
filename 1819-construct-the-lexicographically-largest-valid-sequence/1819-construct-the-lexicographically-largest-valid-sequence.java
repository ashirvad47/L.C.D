class Solution {
    public int[] constructDistancedSequence(int n) {
        int [] res = new int [2*n-1];
        boolean[] visited = new boolean[n+1];
        helper(0,res,visited,n);
        return res;
    }

    private boolean helper( int i, int [] res, boolean [] visited, int n ){
        if(i==res.length) return true;
        if(res[i]!=0) return helper(i+1,res,visited,n);

        for(int j = n ; j >0;j--){
            if(visited[j]==false && (j==1 || i+j < res.length && res[i+j]==0)){
                res[i]=j;
                if( j != 1) res[i+j] =j;
                visited[j]=true;

                if(helper(i+1,res,visited,n)) return true;

                res[i]=0;
                if( j!= 1) res[i+j]=0;
                visited[j]=false; 
            }

        }

        return false;
    }
}