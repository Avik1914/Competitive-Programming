/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
*/

/* Top Down Approach */
class Solution {
    int[] dp;
    public int numSquares(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n);
        
    }
    public int helper(int n){
        if(n==0)
            return 0;
        if(dp[n]!=-1)
            return dp[n];
        int res=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int val=i*i;
            res=Math.min(res,1+helper(n-val));
        }
        dp[n]=res;
        return dp[n];
    }
}

/*Bottom Up Approach*/

class Solution {
    public int numSquares(int n) {
          int dp[]=new int[n+1];
        int max=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            max=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                max=Integer.min(max,1+dp[i-j*j]);
            }
            dp[i]=max;
        }
        return dp[n];
    }
}
