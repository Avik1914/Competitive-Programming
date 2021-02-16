class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        int len=coins.length;
        dp=new Integer[amount+1][len];
        //return dfs2(amount,coins,0);
        
        int[] cache=new int[amount+1];
        cache[0]=1;
        
         for(int c:coins){
            for(int i=1;i<=amount;i++){

                    if(i>=c)
                        cache[i]+=cache[i-c];
            } 
        }
        return cache[amount];
    }
    
    public int dfs1(int amt,int[] coins,int start){
        if(amt==0)
            return 1;
        if(start>=coins.length)
            return 0;
        if(dp[amt][start]!=null)
            return dp[amt][start];
        int ret=0;
        if(amt>=coins[start])
            ret+=dfs1(amt-coins[start],coins,start);
        ret+=dfs1(amt,coins,start+1);
        dp[amt][start]=ret;
        return ret;
    }
    
    
    public int dfs2(int amt,int[] coins,int start){
        if(amt==0)
            return 1;
        if(start>=coins.length)
            return 0;
        if(dp[amt][start]!=null)
            return dp[amt][start];
        int ret=0;
        for(int i=start;i<coins.length;i++){
             if(amt>=coins[i])
                ret+=dfs2(amt-coins[i],coins,i);
        }
        dp[amt][start]=ret;
        return ret;
    }
}