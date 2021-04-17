class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        return Math.max(dfs(nums,0,nums.length-2,new Integer[nums.length]),dfs(nums,1,nums.length-1,new Integer[nums.length]));
    }
    
    public int dfs(int[] nums,int lo,int hi,Integer[] dp){
        if(lo>hi)
            return 0;
        if(dp[lo]!=null)
            return dp[lo];
        dp[lo]=Math.max(nums[lo]+dfs(nums,lo+2,hi,dp),dfs(nums,lo+1,hi,dp));
        return dp[lo];
    }
}