class Solution {
        int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
        int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};
    Double[][][] dp;
    public double knightProbability(int N, int K, int r, int c) {
        dp=new Double[K+1][N][N];
        return dfs(N,K,r,c);
    }
    
    public double dfs(int N,int K,int r,int c){
        if(r>=N || r<0 || c>=N || c<0)
            return 0.0;
        if(dp[K][r][c]!=null)
            return dp[K][r][c];
        if(K==0)
            return 1.0;
        double ret=0.0;
        for(int i=0;i<8;i++)
            ret+=(1.0/8.0)*dfs(N,K-1,r+dr[i],c+dc[i]);
        dp[K][r][c]=ret;
        return ret;
    }
}