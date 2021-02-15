class Solution {
    public int maxCoins(int[] nums) {
        int len=nums.length;
        int[] arr=new int[len+2];
        arr[0]=1;
        arr[len+1]=1;
        for(int i=0;i<len;i++)
            arr[i+1]=nums[i];
        Integer[][] dp=new Integer[len+2][len+2];
        return dfs(arr,0,len+1,dp);
    }
    
    
    public int dfs(int[] nums,int left,int right,Integer[][] dp){
        if(left==right)
            return nums[left];
        if(dp[left][right]!=null)
            return dp[left][right];
        int val=0;
        for(int i=left+1;i<=right-1;i++)
            val=Math.max(val,nums[left]*nums[i]*nums[right]
                         +dfs(nums,left,i,dp)+dfs(nums,i,right,dp));
        dp[left][right]=val;
        return val;
        
    }
}