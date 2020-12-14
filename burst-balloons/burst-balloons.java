class Solution {
    Integer[][] dp;
    public int maxCoins(int[] nums) {
        dp=new Integer[nums.length][nums.length];
        return dfs(nums,0,nums.length-1);
    }
    
    public int dfs(int[] nums,int start,int end){
        if(end<start)
            return 0;
        int res=Integer.MIN_VALUE;
        if(dp[start][end]==null){
            int a=start-1<0?1:nums[start-1];
            int b=end+1>=nums.length?1:nums[end+1];
            
            for(int i=start;i<=end;i++)
                res=Math.max(res,a*nums[i]*b+dfs(nums,start,i-1)+dfs(nums,i+1,end));
            dp[start][end]=res;
        }
        return dp[start][end];
    }
}
