class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        dp=new Integer[amount+1][coins.length];
        return dfs(amount,coins,0);
    }
    
    public int dfs(int amt,int[] coins,int start){
        if(amt==0)
            return 1;
        if(start>=coins.length)
            return 0;
        if(dp[amt][start]!=null)
            return dp[amt][start];
        int ret=0;
        for(int i=start;i<coins.length;i++){
            if(amt>=coins[i])
                ret+=dfs(amt-coins[i],coins,i);
        }
        dp[amt][start]=ret;
        return ret;
    }
}