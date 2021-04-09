class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        int row=forest.size();
        int col=forest.get(0).size();
        PriorityQueue<int[]> pq=new PriorityQueue<>
            ((a,b)->forest.get(a[0]).get(a[1])-forest.get(b[0]).get(b[1]));
        
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(forest.get(i).get(j)>1)
                    pq.add(new int[]{i,j});
            }
        }
        
        int[] start=new int[]{0,0};
        int steps=0;
        while(!pq.isEmpty()){
            int[] end=pq.poll();
            int val=bfs(forest,start,end);
            if(val==-1)
                return -1;
            steps+=val;
            start[0]=end[0];
            start[1]=end[1];
        }
        return steps;
    }
    
    
    
    
    
    
    public int bfs(List<List<Integer>> forest,int[] start,int[] end){
        int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
        
        Queue<int[]> queue=new LinkedList<>();
        queue.add(start);
        int row=forest.size();
        int col=forest.get(0).size();
        int levels=0;
        boolean[][] visited=new boolean[row][col];
        visited[start[0]][start[1]]=true;
        
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                int[] val=queue.poll();
                if(val[0]==end[0] && val[1]==end[1])
                    return levels;
                for(int[] d:dir){
                    int nr=d[0]+val[0];
                    int nc=d[1]+val[1];
                    
                    if(nr<0 || nc<0 || nr>=row || nc>=col || forest.get(nr).get(nc)==0 ||
                      visited[nr][nc])
                        continue;
                    visited[nr][nc]=true;
                    queue.offer(new int[]{nr,nc});
                }
            }
            levels++;
        }
        
        return -1;
    }
}