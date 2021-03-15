class Solution {
    Integer[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp=new Integer[coins.length][amount+1];
        int a=dfs(coins,0,amount);
        return a==Integer.MAX_VALUE?-1:a;
    }
    
    public int dfs(int[] coins,int start,int amount){
        if(amount==0)
            return 0;
        if(start>=coins.length || amount<0)
            return Integer.MAX_VALUE;
        if(dp[start][amount]==null){
        int res=0;
        int a=dfs(coins,start,amount-coins[start]);
        int b=dfs(coins,start+1,amount);
        if(a!=Integer.MAX_VALUE)
            a++;
        dp[start][amount]=Math.min(a,b);
        }
        return dp[start][amount];
    }
}