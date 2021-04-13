class Solution {
    public int lastStoneWeightII(int[] stones) {
        int len=stones.length;
        int sum=0;
        
        for(int s:stones)
            sum+=s;
        boolean[][] dp=new boolean[sum+1][len+1];
        Arrays.fill(dp[0],true);
        
        for(int i=1;i<=sum;i++){
            for(int j=1;j<=len;j++){
                if(stones[j-1]<=i)
                    dp[i][j]=dp[i-stones[j-1]][j-1] || dp[i][j-1];
                else
                    dp[i][j]=dp[i][j-1];
            }    
        }
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<=(sum+1)/2;i++){
            if(dp[i][len])
                min=Math.min(min,Math.abs(i-sum+i));
        }
        
        
        return min;
        
    }
    
    public int dfs(int[] stones,int target,int start){
        if(target<=0 || start>=stones.length)
            return Math.abs(target);
        
        
        return Math.min(dfs(stones,target-stones[start],start+1),
                            dfs(stones,target,start+1));
    }
}