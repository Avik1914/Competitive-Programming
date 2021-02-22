class Solution {
    int[][] dp;
    public int maximumScore(int[] nums, int[] multipliers) {
        dp=new int[multipliers.length+1][multipliers.length+1];
        int m=multipliers.length;
        
        for(int i=m-1;i>=0;i--){
            for(int j=0;j<=i;j++){
               dp[i][j]=Math.max(nums[j]*multipliers[i]+dp[i+1][j+1],
                        nums[nums.length-(i-j+1)]*multipliers[i]+dp[i+1][j]);
            }
        }
        
        return dp[0][0];
    }
    
   /* public int dfs(int[] nums,int[] multipliers,int start,int pres){
        if(pres>=multipliers.length)
            return 0;
        if(dp[start][pres]!=null)
            return dp[start][pres];
        int l=nums[start]*multipliers[pres]+dfs(nums,multipliers,start+1,pres+1);
    int r=nums[nums.length-(pres-start+1)]*multipliers[pres]+dfs(nums,multipliers,start,pres+1);
        dp[start][pres]=Math.max(l,r);
        return dp[start][pres];
        
    }*/
}