class Solution {
    Integer[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int len=cost.length;
        dp=new Integer[len];
        return Math.min(dfs(cost,0),dfs(cost,1));
    }
    
    public int dfs(int[] cost,int start){
        if(start>=cost.length)
            return 0;
        if(dp[start]!=null)
            return dp[start];
        dp[start]=cost[start]+Math.min(dfs(cost,start+1),dfs(cost,start+2));
        return dp[start];
    }
}