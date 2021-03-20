class Solution {
    int[][] gcd;
    Integer[][] dp;
    public int maxScore(int[] nums) {
        int len=nums.length;
        dp=new Integer[len][16385];
        gcd=new int[len][len];
        
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                gcd[i][j]=gcd(nums[i],nums[j]);
                
            }
        }
        return dfs(nums,1,0);
    }
    
    public int dfs(int[] nums,int start,int mask){
        if(start==(nums.length/2)+1)
            return 0;
        int res=Integer.MIN_VALUE;
        if(dp[start][mask]!=null)
            return dp[start][mask];
        for(int i=0;i<nums.length;i++){
            if((mask & (1<<i))==0){
                mask|=1<<i;
                for(int j=i+1;j<nums.length;j++){
                        if((mask & (1<<j))==0){
                            mask|=1<<j;
                            res=Math.max(res,gcd[i][j]*start+dfs(nums,start+1,mask));
                            mask^=1<<j;
                        }
                }
                mask^=1<<i;
            }
        }
        dp[start][mask]=res;
        return res;
    }
    
    
    public int gcd(int a,int b){
        if (b == 0)
            return a;
      return gcd(b, a % b); 
    }
    
}