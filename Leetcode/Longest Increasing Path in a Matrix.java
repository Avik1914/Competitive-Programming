/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/

class Solution {
    int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int r=matrix.length;
        if(r==0)
            return 0;
        int c=matrix[0].length;
        if(c==0)
            return 0;
        int res=0;
        
        int[][] dp=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(dp[i][j]==0)
                    res=Math.max(res,dfs(matrix,i,j,dp));
            }
        }
        return res;
    }
    
    public int dfs(int[][] mat,int r,int c,int[][] dp){
        if(dp[r][c]!=0)
            return dp[r][c];
        for(int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];
            if(nr<mat.length && nc<mat[0].length && nr>=0 && nc>=0 && mat[r][c]<mat[nr][nc])
                    dp[r][c]=Math.max(dp[r][c],1+dfs(mat,nr,nc,dp));
            
        }
        return dp[r][c];
    }
}
