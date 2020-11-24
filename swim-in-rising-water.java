class Solution {
    public int swimInWater(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        
        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->a[2]-b[2]);
        queue.add(new int[]{0,0,grid[0][0]});
        int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
        int res=0;
        boolean[][] visit=new boolean[r][c];
        visit[0][0]=true;
        while(!queue.isEmpty()){
            int[] val=queue.poll();
            res=Math.max(res,val[2]);
            if(val[0]==r-1 && val[1]==c-1)
                return res;
            
            for(int[] d:dir){
                int nr=val[0]+d[0];
                int nc=val[1]+d[1];
                if(nr>=0 && nc>=0 && nr<r && nc<c && !visit[nr][nc]){
                    visit[nr][nc]=true;
                    queue.add(new int[]{nr,nc,grid[nr][nc]});
                }
            }
        }
        
        return -1;
    }
}
