class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n:nums)
            sum+=n;
        if(sum%2!=0)
            return false;
        sum=sum/2;
        int len=nums.length;
        boolean[][] dp=new boolean[len+1][sum+1];
        
        for(int i=0;i<=len;i++){
            for(int j=0;j<=sum;j++){
                if(j==0)
                    dp[i][j]=true;
                else if(i==0)
                    dp[i][j]=false;
                else{
                    if(nums[i-1]<=j)
                        dp[i][j]=dp[i-1][j-nums[i-1]];
                    dp[i][j]=dp[i][j]||dp[i-1][j];
                }
            }
        }
        
        return dp[len][sum];
    }
}
