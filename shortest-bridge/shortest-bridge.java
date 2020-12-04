class Solution {
    int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
    public int shortestBridge(int[][] A) {
        int len=A.length;
        boolean[][] visit=new boolean[len][len];
        Queue<int[]> queue=new LinkedList();
        boolean flag=false;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(A[i][j]==1){
                    dfs(A,visit,i,j,queue);
                    flag=true;
                    break;
                }
            }
            if(flag)
                break;
        }
        int res=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            
            while(size-->0){
                int[] val=queue.poll();
                if(A[val[0]][val[1]]==1)
                    return res;
                for(int[] d:dir){
                    int nr=val[0]+d[0];
                    int nc=val[1]+d[1];
                    if(nr>=0 && nc>=0 && nr<len && nc<len && !visit[nr][nc]){
                        visit[nr][nc]=true;
                        queue.add(new int[]{nr,nc});
                    }
                }
            }
            res++;
        }
        return -1;
        
    }
    
    public void dfs(int[][] A,boolean[][] visit,int i,int j,Queue<int[]> queue){
        if(i<0 || j<0 || i>=A.length || j>=A.length || visit[i][j])
            return;
       
        visit[i][j]=true;
        if(A[i][j]==0)
            queue.add(new int[]{i,j});
        else{
            for(int[] d:dir){
                
                dfs(A,visit,i+d[0],j+d[1],queue);
            }
            
        }
    }
