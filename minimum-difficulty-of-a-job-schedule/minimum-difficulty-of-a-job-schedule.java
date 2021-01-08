class Solution {
    int[] prefixMax;
    Integer[][] dp;
    public int minDifficulty(int[] jobDifficulty, int d) {
        int len=jobDifficulty.length;
        if(len<d)
            return -1;
        dp=new Integer[len][d+1];
        prefixMax=new int[len];
        int max=0;
        for(int i=len-1;i>=0;i--){
            max=Math.max(jobDifficulty[i],max);
            prefixMax[i]=max;
        }
        return dfs(jobDifficulty,0,d);    
            
    }
    
    public int dfs(int[] arr,int start,int d){
        if(d==1)
            return prefixMax[start];
        if(dp[start][d]!=null)
            return dp[start][d];
        int max=0;
        int ans=Integer.MAX_VALUE;
        for(int i=start;i<=arr.length-d;i++){
            max=Math.max(max,arr[i]);
            ans=Math.min(ans,max+dfs(arr,i+1,d-1));
        }
        dp[start][d]=ans;
        return dp[start][d];
    }
}
