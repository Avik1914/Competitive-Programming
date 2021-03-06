class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        dp=new Boolean[s.length()+1][p.length()+1];
        return dfs(s.toCharArray(),p.toCharArray(),s.length()-1,p.length()-1);
    }
    
    public boolean dfs(char[] s,char[] p,int l1,int l2){
        if(dp[l1+1][l2+1]!=null)
            return dp[l1+1][l2+1];
        if(l2<0 && l1<0)
            dp[l1+1][l2+1]=true;
        else if(l2<0)
            dp[l1+1][l2+1]=false;
        else if(l1<0){
            if(p[l2]=='*')
                dp[l1+1][l2+1]=dfs(s,p,l1,l2-1);
            else
                dp[l1+1][l2+1]=false;
        }else{
            if(p[l2]=='*')
                dp[l1+1][l2+1]=dfs(s,p,l1-1,l2) || dfs(s,p,l1,l2-1);
            else if(p[l2]=='?')
                dp[l1+1][l2+1]=dfs(s,p,l1-1,l2-1);
            else 
                dp[l1+1][l2+1]=s[l1]==p[l2] && dfs(s,p,l1-1,l2-1);
        }
        return dp[l1+1][l2+1];
    }
}