class UnionFind{
    int[] parent;
    int[] size;
    int noOfComp=0;
    UnionFind(int n){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=-1;
            size[i]=1;
        }
    }
    
    public void increase(int val){
        parent[val]=val;
        noOfComp++;
    }
    
    public int find(int root){
        int temp=root;
        while(root!=parent[root])
            root=parent[root];
        while(temp!=parent[temp]){
            int next=parent[temp];
            parent[temp]=root;
            temp=next;
        }
        return root;
    }
    
    public void union(int a,int b){
        int par1=find(a);
        int par2=find(b);
        if(par1==par2)
            return;
        noOfComp--;
        if(size[par1]>size[par2]){
            size[par1]+=size[par2];
            parent[par2]=par1;
        }else{
            size[par2]+=size[par1];
            parent[par1]=par2;
        }
        
    }
}


class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] mat=new int[m][n];
        UnionFind uf=new UnionFind(m*n);
        int[][] dir={{-1,0},{0,1},{0,-1},{1,0}};
        List<Integer> res=new ArrayList();
        
        for(int[] p:positions){
            mat[p[0]][p[1]]=1;
            int val=p[0]*n+p[1];
            if(uf.parent[val]==-1)
                uf.increase(val);
            for(int[] d:dir){
                int nr=d[0]+p[0];
                int nc=d[1]+p[1];
                
                if(nr<0 || nc<0 || nr>=m || nc>=n || mat[nr][nc]==0)
                    continue;
                uf.union(nr*n+nc,val);
            }
            res.add(uf.noOfComp);
        }
        
        return res;
    }
}