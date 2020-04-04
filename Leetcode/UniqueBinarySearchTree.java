/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

/*Memoization */

class Solution {
    int[] dp;
    public int numTrees(int n) {
        dp=new int[n+1];
		return dfs(n);  
    }
    
    public int dfs(int n){
        if(n<2)
            return 1;
        if(dp[n]!=0)
            return dp[n];
        int noOfWays=0;
        for(int i=1;i<=n;i++){
            noOfWays+=dfs(i-1)*dfs(n-i);
        }
        dp[n]=noOfWays;
        return noOfWays;
    }
}

/*Tabular */
class Solution {
    public int numTrees(int n) {
            int[] dp=new int[n+1];
		    dp[0]=1;
		    for(int i=1;i<=n;i++){
		        for(int j=0;j<i;j++){
		            dp[i]+=dp[j]*dp[i-j-1];
		        }
		    }
		    return dp[n];
    }
}

