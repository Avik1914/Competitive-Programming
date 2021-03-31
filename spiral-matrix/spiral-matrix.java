class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        
        boolean[][] visit=new boolean[row][col];
        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        
        int x=0,y=-1;
        int itr=0;
        List<Integer> res=new ArrayList();
        
        for(int i=0;i<row*col;i++){
            x+=dir[itr][0];
            y+=dir[itr][1];
            if(x<0 || y<0 || x>=row || y>=col || visit[x][y]){
                x-=dir[itr][0];
                y-=dir[itr][1];
                itr=(itr+1)%4;
                x+=dir[itr][0];
                y+=dir[itr][1];
            }
            res.add(matrix[x][y]);
            visit[x][y]=true;
        }
        
        return res;
    }
}