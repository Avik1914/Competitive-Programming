/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20
*/

class Solution {
    int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    int val=1;
    public int[][] generateMatrix(int n) {
        int[][] grid=new int[n][n];
        dfs(grid,0,0,n,0);
        return grid;
    }
    
    public void dfs(int[][] grid,int r,int c,int n,int way){
        if(r>=n || c>=n || r<0 || c<0 || grid[r][c]!=0)
            return;
        grid[r][c]=val++;
        for(int i=0;i<4;i++){
            way=way+i;
            dfs(grid,r+dir[way%4][0],c+dir[way%4][1],n,way);
        }
    }
}
