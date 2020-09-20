/*
On a 2-dimensional grid, there are 4 types of squares:

1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

 

Example 1:

Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:

Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:

Input: [[0,1],[2,0]]
Output: 0
Explanation: 
There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
 

Note:

1 <= grid.length * grid[0].length <= 20
*/

class Solution {
    int res=0;
    int[][] dir={{-1,0},{0,1},{0,-1},{1,0}};
    public int uniquePathsIII(int[][] grid) {
        int count=0;
        int row=grid.length;
        int col=grid[0].length;
        int[] start=new int[2];
        int[] end=new int[2];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0)
                    count++;
                else if(grid[i][j]==1){
                    start[0]=i;
                    start[1]=j;
                }else if(grid[i][j]==2){
                    end[0]=i;
                    end[1]=j;
                }
            }
        }
        
        dfs(grid,start[0],start[1],end,new boolean[row][col],count);
        
        return res;
        
    }
    
    public void dfs(int[][] grid,int r,int c,int[] end,boolean[][] visit,int count){
        if(r==end[0] && c==end[1]){
            if(count==0)
                res++;
            return;
        }
        visit[r][c]=true;
        for(int i=0;i<4;i++){
            int nr=r+dir[i][0];
            int nc=c+dir[i][1];
            if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length 
                                && grid[nr][nc] !=-1 && !visit[nr][nc]){
               
                count=grid[nr][nc]==0?count-1:count;
                dfs(grid,nr,nc,end,visit,count);
                count=grid[nr][nc]==0?count+1:count;
            }
        }
        visit[r][c]=false;
        
    }
}
