/*
Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:

The order of returned grid coordinates does not matter.
Both m and n are less than 150.
 

Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
*/

class Solution {
    int[][] dir={{-1,0},{0,-1},{1,0},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res=new ArrayList();
        
        int m=matrix.length;
        if(m==0)
            return res;
        int n=matrix[0].length;
        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];
        
        for(int i=0;i<m;i++){
            dfs(matrix,i,0,atlantic,Integer.MIN_VALUE);
            dfs(matrix,i,n-1,pacific,Integer.MIN_VALUE);
        }
        
        for(int i=0;i<n;i++){
            dfs(matrix,0,i,atlantic,Integer.MIN_VALUE);
            dfs(matrix,m-1,i,pacific,Integer.MIN_VALUE);
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(atlantic[i][j] && pacific[i][j]){
                    List<Integer> temp=new ArrayList();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        
        return res;
    }
    
    public void dfs(int[][] matrix,int i,int j, boolean[][] visit,int prev){
        if(i>=matrix.length || j>=matrix[0].length || i<0 || j<0 || visit[i][j] || prev>matrix[i][j])
            return ;
        visit[i][j]=true;
        for(int[] d:dir)
           dfs(matrix,i+d[0],j+d[1],visit,matrix[i][j]);
    }
}
