/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:
11000
11000
00011
00011
Given the above grid map, return 1.
Example 2:
11011
10000
00001
11011
Given the above grid map, return 3.

Notice that:
11
1
and
 1
11
are considered different island shapes, because we do not consider reflection / rotation.
Note: The length of each dimension in the given grid does not exceed 50.
*/

class Solution {
    Set<String> set;
    boolean[][] visit;
    int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
    String[] dirStr={"U","D","R","L"};
    public int numDistinctIslands(int[][] grid) {
        set=new HashSet();
        int r=grid.length;
        if(r==0)
            return 0;
        int c=grid[0].length;
        visit=new boolean[r][c];
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1 && !visit[i][j]){
                    StringBuilder sb=new StringBuilder();
                    sb.append("S");
                    dfs(grid,i,j,sb);
                    set.add(sb.toString());
                    System.out.println(sb.toString());
                }
            }
        }
        return set.size();
    }
    
    public void dfs(int[][] grid,int r,int c,StringBuilder sb){
        visit[r][c]=true;
        for(int i=0;i<4;i++){
            int nr=dir[i][0]+r;
            int nc=dir[i][1]+c;
            if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==1 && !visit[nr][nc]){ 
                sb.append(dirStr[i]);
                dfs(grid,nr,nc,sb);
                sb.append(",");
            }
            
        }
        
    }
}
