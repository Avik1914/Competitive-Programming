class Solution {
    public boolean isBipartite(int[][] graph) {
        int len=graph.length;
        int[] color=new int[len];
        
        Queue<Integer> queue=new LinkedList();
        for(int i=0;i<len;i++){
            if(color[i]==0){
                queue.add(i);
                if(!bfs(queue,color,graph))
                    return false;
            }
        }
        return true;
    }
    
    public boolean bfs(Queue<Integer> queue,int[] color,int graph[][]){
        
        int clr=1;
        
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                int val=queue.poll();
                color[val]=clr;
                for(int i:graph[val]){
                    if(color[i]!=0 && color[i]==clr)
                        return false;
                    if(color[i]==0)
                        queue.add(i);
                }
            }
            clr=clr==1?2:1;
        }
        return true;
    }
}