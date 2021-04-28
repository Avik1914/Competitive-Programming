class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        
        Queue<int[]> queue=new LinkedList<>();
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==0)
                    queue.add(new int[]{i,j});
            }
        }
        
        int[][] res=new int[row][col];
        int cnt=1;
        int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
        
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                int[] val=queue.poll();
                for(int[] d:dir){
                    int nr=d[0]+val[0];
                    int nc=d[1]+val[1];
                    if(nr>=0 && nc>=0 && nr<row && nc<col && mat[nr][nc]==1 
                      && res[nr][nc]==0){
                        res[nr][nc]=cnt;
                        queue.add(new int[]{nr,nc});
                    }
                }
            }
            cnt++;
        }
        
        return res;
    }
}