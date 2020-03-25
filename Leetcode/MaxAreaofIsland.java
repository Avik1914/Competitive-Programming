/*

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        UnionFind uf=new UnionFind(grid,r,c);
        if(!uf.pres)
            return 0;
        int[][] dir={{-1,0},{0,-1},{1,0},{0,1}};
        //boolean visit[][]=new boolean[r][c];
        int res=1;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    for(int[] d:dir){
                        if(i+d[0]<r && i+d[0]>=0 && j+d[1]<c && j+d[1]>=0 && grid[i+d[0]][j+d[1]]==1){
                            res=Math.max(res,uf.union(i*c+j,(i+d[0])*c+j+d[1]));
                        }
                    }
                }
            }
        }
     return res;   
    }
}

class UnionFind{
    int[] parent;
    int[] size;
    boolean pres;
    UnionFind(int[][] grid,int r,int c){
        pres=false;
        parent=new int[r*c];
        size=new int[r*c];
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    pres=true;
                    int len=i*c+j;
                    parent[len]=len;
                    size[len]=1;
                }
            }
        }
        
    }
    
    public int union(int a,int b){
        int a1=find(a);
        int a2=find(b);
        if(a1!=a2){
            if(size[a1]>size[a2]){
                parent[a2]=a1;
                size[a1]+=size[a2];
            }else{
               parent[a1]=a2;
               size[a2]+=size[a1]; 
            }
        }
        return Math.max(size[a2],size[a1]);
    }
    
    public int find(int a){
        int next=a;
        while(parent[a]!=a)
            a=parent[a];
        while(parent[next]!=a){
            int val=parent[next];
            parent[next]=a;
            next=val;
        }
        return a;
    }
}
