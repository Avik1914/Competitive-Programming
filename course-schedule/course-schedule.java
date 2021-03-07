class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph=new ArrayList[numCourses];
        
        for(int i=0;i<numCourses;i++)
            graph[i]=new ArrayList();
        int[] visited=new int[numCourses];
        
        for(int[] a:prerequisites)
            graph[a[1]].add(a[0]);
        
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0 && !dfs(graph,visited,i)){
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(List<Integer>[] graph,int[] visited,int node){
        if(visited[node]==-1)
            return false;
        if(visited[node]==1)
            return true;
        visited[node]=-1;
        for(int a:graph[node]){
            if(!dfs(graph,visited,a))
                return false;
        }
        visited[node]=1;
        return true;
    }
}