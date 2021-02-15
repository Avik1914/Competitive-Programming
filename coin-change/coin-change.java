class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int len=coins.length;
        int[] dp=new int[amount+1];
        int res=0;
        Arrays.fill(dp,Integer.MAX_VALUE);
        Arrays.sort(coins);
        dp[0]=0;
        
        for(int i=1;i<=amount;i++){
            for(int j=0;j<len;j++){
               if(i>=coins[j]){
                   if(dp[i-coins[j]]!=Integer.MAX_VALUE)
                        dp[i]=Math.min(dp[i],1+dp[i-coins[j]]);      
               }
            }
        }
        
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}