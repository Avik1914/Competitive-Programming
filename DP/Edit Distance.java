/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
*/

class Solution {
    public int minDistance(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int[][] dp=new int[len1+1][len2+1];
        
        for(int i=0;i<=len1;i++)
            dp[i][0]=i;
        for(int j=0;j<=len2;j++)
            dp[0][j]=j;
        
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
            }
        }
        
        
        //return dfs(word1.toCharArray(),word2.toCharArray(),word1.length()-1,word2.length()-1);
        return dp[len1][len2];
    }
    /*Memoization Approach*/
    /*public int dfs(char[] w1,char[] w2,int s1,int s2){
        if(s1<0 && s2<0)
            return 0;
        if(s1<0 || s2<0)
            return Math.abs(s1-s2);
        if(dp[s1][s2]!=null)
          return dp[s1][s2];
        if(w1[s1]==w2[s2]){
            dp[s1][s2]=dfs(w1,w2,s1-1,s2-1);
            return dp[s1][s2];
        }
        int val=Integer.MAX_VALUE;
        val=Math.min(val,1+dfs(w1,w2,s1,s2-1));
        val=Math.min(val,1+dfs(w1,w2,s1-1,s2));
        val=Math.min(val,1+dfs(w1,w2,s1-1,s2-1));
        dp[s1][s2]=val;
        return dp[s1][s2];
    }*/
}
