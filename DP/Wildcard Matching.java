/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
*/

class Solution {
    
    public boolean isMatch(String s, String p) {
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        //dp[0][0]=true;
        int m=s.length();
        int n=p.length();

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 && j==0)
                    dp[0][0]=true;
                else if(i==0 || j==0){
                    if(j==0)
                        dp[i][j]=false;
                    else if(p.charAt(j-1)=='*')
                        dp[i][j]=dp[i][j-1];
                    else
                        dp[i][j]=false;
                }
                else{
                        char c=s.charAt(i-1);
                        char d=p.charAt(j-1);
                        
                        if(d=='?' || c==d)
                            dp[i][j]=dp[i-1][j-1];
                        else if(d=='*')
                            dp[i][j]=dp[i][j-1] || dp[i-1][j];
                        else
                            dp[i][j]=false;
                }
            }
        }
        //return dfs(s.toCharArray(),p.toCharArray(),s.length()-1,p.length()-1);
        return dp[m][n];
    }
    
    /*public boolean dfs(char[] s,char[] p,int l1,int l2){
        if(dp[l1+1][l2+1]!=null)
            return dp[l1+1][l2+1];
        if(l1<0 && l2<0)
            dp[l1+1][l2+1]=true;
        else if(l1<0 || l2<0){
            if(l2>=0 && p[l2]=='*')
                dp[l1+1][l2+1]=dfs(s,p,l1,l2-1);
            else
                dp[l1+1][l2+1]=false;
        }
        else if(p[l2]=='*')
            dp[l1+1][l2+1]=dfs(s,p,l1-1,l2) || dfs(s,p,l1,l2-1);
        else if(p[l2]=='?' || p[l2]==s[l1])
            dp[l1+1][l2+1]=dfs(s,p,l1-1,l2-1);
        else
            dp[l1+1][l2+1]=false;
        return dp[l1+1][l2+1];
    }*/
}
