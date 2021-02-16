class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;
        
        for(int i=1;i<=target;i++){
            for(int n:nums){
                if(n<=i)
                    dp[i]+=dp[i-n];
            }
        }
        
        
        return dp[target];
    }
    
    public int dfs(int[] nums,int target){
        if(target==0)
            return 1;
        int ret=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=target)
                ret+=dfs(nums,target-nums[i]);
        }
        
        return ret;
    }
}