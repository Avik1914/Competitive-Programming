class Solution {
    Integer[][] dp;
    public int maximumScore(int[] nums, int[] multipliers) {
        dp=new Integer[multipliers.length][multipliers.length];
        return dfs(nums,multipliers,0,0);
    }
    
    public int dfs(int[] nums,int[] multipliers,int start,int pres){
        if(pres>=multipliers.length)
            return 0;
        if(dp[start][pres]!=null)
            return dp[start][pres];
        int l=nums[start]*multipliers[pres]+dfs(nums,multipliers,start+1,pres+1);
    int r=nums[nums.length-(pres-start+1)]*multipliers[pres]+dfs(nums,multipliers,start,pres+1);
        dp[start][pres]=Math.max(l,r);
        return dp[start][pres];
        
    }
}