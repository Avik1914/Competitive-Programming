class Solution {
    Integer[] dp;
    public int minSteps(int n) {
        dp=new Integer[n+1];
        return dfs(n);
    }
    
    public int dfs(int n){
        if(n<=1)
            return 0;
        if(dp[n]!=null)
            return dp[n];
        int min=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            if(n%i==0)
                min=Math.min(1+dfs(i)+n/i-1,min);
        }
        dp[n]=min;
        return min;
    }
}