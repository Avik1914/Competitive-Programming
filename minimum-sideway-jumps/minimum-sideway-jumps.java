class Solution {
    Integer[][] dp;
    public int minSideJumps(int[] obstacles) {
        dp=new Integer[4][obstacles.length];
        return dfs(obstacles,2,0);
    }
    
    public int dfs(int[] obs,int path,int ind){
        if(ind==obs.length-1)
            return 0;
        if(dp[path][ind]!=null)
            return dp[path][ind];
      
        if(ind+1<obs.length && obs[ind+1]==path){
            if(path==1)
                dp[path][ind]=Math.min((obs[ind]==2?2:1)+dfs(obs,2,ind+1),(obs[ind]==3?2:1)+dfs(obs,3,ind+1));
            else if(path==2)
                dp[path][ind]=Math.min((obs[ind]==1?2:1)+dfs(obs,1,ind+1),(obs[ind]==3?2:1)+dfs(obs,3,ind+1));
            else
                dp[path][ind]=Math.min((obs[ind]==2?2:1)+dfs(obs,2,ind+1),(obs[ind]==1?2:1)+dfs(obs,1,ind+1));
        }else
            dp[path][ind]=dfs(obs,path,ind+1);
        
        return dp[path][ind];
    }
}