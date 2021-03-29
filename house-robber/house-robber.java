class Solution {
    public int rob(int[] nums) {
        int len=nums.length;
        int[] dp=new int[len+1];
        
        dp[0]=0;
        dp[1]=nums[0];
        
        for(int i=1;i<len;i++)
            dp[i+1]=Math.max(nums[i]+dp[i-1],dp[i]);
        
        return dp[len];
    }
}