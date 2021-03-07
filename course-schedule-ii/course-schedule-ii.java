class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
     
        
        List<Integer>[] graph=new ArrayList[numCourses];
        
        for(int i=0;i<numCourses;i++)
            graph[i]=new ArrayList();
        
        int[] indegree=new int[numCourses];
        
        for(int[] a:prerequisites){
            graph[a[1]].add(a[0]);
            indegree[a[0]]++;
        }
        Queue<Integer> queue=new LinkedList();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                queue.add(i);
        }
        int[] res=new int[numCourses];
        int itr=0;
        while(!queue.isEmpty()){
            int val=queue.poll();
            res[itr++]=val;
             for(int a:graph[val]){
                if(--indegree[a]==0)
                    queue.add(a);
             }   
        }
        
        
       
        return itr==numCourses?res:new int[0];
        
    }
}