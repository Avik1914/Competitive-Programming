class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] graph=new int[n][n];
        int[] degree=new int[n];
        for(int[] r:roads){
            graph[r[0]][r[1]]=1;
            graph[r[1]][r[0]]=1;
            degree[r[0]]++;
            degree[r[1]]++;
        }
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j)
                    res=Math.max(res,degree[i]+degree[j]-graph[i][j]);
            }
        }
        
        return res;
    }
}