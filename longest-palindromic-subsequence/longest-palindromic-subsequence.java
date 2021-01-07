class Solution {
    Integer[][] dp;
    public int longestPalindromeSubseq(String s) {
        char[] arr=s.toCharArray();
        int len=arr.length;
        dp=new Integer[len][len];
        int res=0;
        for(int i=0;i<len;i++){
            int lo=0;
            int hi=i;
            while(hi<len){
                if(lo==hi)
                    dp[lo][hi]=1;
                else if(lo+1==hi && arr[lo]==arr[hi])
                    dp[lo][hi]=2;
                else if(arr[lo]==arr[hi])
                    dp[lo][hi]=2+dp[lo+1][hi-1];
                else
                    dp[lo][hi]=Math.max(dp[lo][hi-1],dp[lo+1][hi]);
                res=Math.max(dp[lo][hi],res);
                lo++;
                hi++;
            }
        }
        
        
        
        
        return res;
        
    }
    
    public int dfs(char[] arr,int lo,int hi){
        if(lo>=hi)
            return lo==hi?1:0;
        if(dp[lo][hi]!=null)
            return dp[lo][hi];
        if(arr[lo]==arr[hi])
            dp[lo][hi]=2+dfs(arr,lo+1,hi-1);
        else
            dp[lo][hi]=Math.max(dfs(arr,lo+1,hi),dfs(arr,lo,hi-1));
        return dp[lo][hi];
    }
}
