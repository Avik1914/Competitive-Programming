class Solution {
    boolean[][] dp;
    Boolean[][] dp1;
    public boolean checkPartitioning(String s) {
        char[] arr=s.toCharArray();
        int len=arr.length;
        dp=new boolean[len+1][len+1];
        dp1=new Boolean[len+1][4];
        
        for(int i=0;i<len;i++){
            int r=0;
            int c=i;
            while(c<len){
                if(c-r<=1 && arr[r]==arr[c])
                    dp[r][c]=true;
                else if(arr[r]==arr[c])
                    dp[r][c]=dp[r+1][c-1];
                r++;
                c++;
            }
        }
        
        return dfs(arr,0,3);
    }
    
    public boolean dfs(char[] s,int start,int cnt){
        if(start>=s.length){
            return cnt==0;
        }
        if(cnt<=0)
            return false;
        if(dp1[start][cnt]!=null)
            return dp1[start][cnt];
        for(int i=start;i<s.length;i++){
            if(dp[start][i] && dfs(s,i+1,cnt-1)){
                dp1[start][cnt]=true;
                return true;
            }
        }
        dp1[start][cnt]=false;
        return false;
    }
}