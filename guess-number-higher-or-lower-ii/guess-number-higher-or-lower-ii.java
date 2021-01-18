class Solution {
    Integer[][] dp;
    public int getMoneyAmount(int n) {
        dp=new Integer[n+1][n+1];
        return dfs(1,n);
    }
    
    public int dfs(int lo,int hi){
        if(hi-lo<1)
            return 0;
        if(hi-lo==1)
            return lo;
        if(dp[lo][hi]!=null)
            return dp[lo][hi];
        int max=Integer.MAX_VALUE;
        for(int i=lo;i<=hi;i++){
            max=Math.min(max,i+Math.max(dfs(lo,i-1),dfs(i+1,hi)));
        }
        dp[lo][hi]=max;
        return max;
    }
}
