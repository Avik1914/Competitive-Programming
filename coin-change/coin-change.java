class Solution {
    public int coinChange(int[] coins, int amount) {
        int len=coins.length;
        
        int[] dp=new int[amount+1];
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int j=0;j<len;j++){
                if(coins[j]<=i && dp[i-coins[j]]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],1+dp[i-coins[j]]);
                }
            }
        }
        
        
        
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
    
    public int dfs(int[] coins,int amt){
        if(amt==0)
            return 0;
        int ret=Integer.MAX_VALUE;
       for(int i=0;i<coins.length;i++){
           if(coins[i]<=amt){
               int a=dfs(coins,amt-coins[i]);
               if(a!=Integer.MAX_VALUE)
                   a++;
               ret=Math.min(ret,a);
            }
       }
        
        return ret;
       
    }
}