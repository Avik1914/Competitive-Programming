class Solution {
    public int numIslands(char[][] grid) {
        int[][] dir={{1,0},{0,1}};
        int r=grid.length;
        int c=grid[0].length;
        UnionFind uf=new UnionFind(grid);
        
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    for(int[] d:dir){
                        int nr=d[0]+i;
                        int nc=d[1]+j;
                        if(nr<r && nc<c && grid[nr][nc]=='1')
                            uf.union(nr*c+nc,i*c+j);
                    }
                }
            }
        }
        
        return uf.component;
    }
}
​
class UnionFind{
    int[] parent;
    int[] size;
    int component;
    UnionFind(char[][] g){
        component=0;
        int r=g.length;
        int c=g[0].length;
        parent=new int[r*c];
        size=new int[r*c];
        
        for(int i=0;i<g.length;i++){
            for(int j=0;j<g[0].length;j++){
                int val=i*c+j;
                if(g[i][j]=='1'){
                    parent[val]=val;
                    size[val]=1;
                    component++;
                }else{
                    parent[val]=-1;
                    size[val]=-1;
                }
            }
        }
    }
    
    public int find(int ind){
       int originalInd=ind;
        while(parent[ind]!=ind)
            ind=parent[ind];
