class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        return Math.max(calc(nums,0,nums.length-2),calc(nums,1,nums.length-1));
    }
    
    public int calc(int[] nums,int lo,int hi){
        if(lo>hi)
            return 0;
        int[] dp=new int[hi+2];
        
        dp[lo]=0;
        dp[lo+1]=nums[lo];
        
        for(int i=lo+1;i<=hi;i++)
            dp[i+1]=Math.max(nums[i]+dp[i-1],dp[i]);
        
        return dp[hi+1];
    }
}