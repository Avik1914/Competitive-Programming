class Solution {
    Integer[][][] dp;
    public int longestPalindromeSubseq(String s) {
        int len=s.length();
        dp=new Integer[len][len][27];
        char[] arr=s.toCharArray();
        return dfs(arr,0,len-1,'{');
    }
    
    public int dfs(char[] arr,int lo,int hi,char prev){
        if(lo>=hi)
            return 0;
        if(dp[lo][hi][prev-'a']!=null)
            return dp[lo][hi][prev-'a'];
        if(arr[lo]==arr[hi] && arr[lo]!=prev)
            dp[lo][hi][prev-'a']=2+dfs(arr,lo+1,hi-1,arr[lo]);
        else
            dp[lo][hi][prev-'a']=Math.max(dfs(arr,lo+1,hi,prev),dfs(arr,lo,hi-1,prev));
        return dp[lo][hi][prev-'a'];
    }
}
