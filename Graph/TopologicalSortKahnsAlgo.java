class TopologicalSort
{
    static int[] topoSort(ArrayList<ArrayList<Integer>> list, int N)
    {
       Queue<Integer> queue=new LinkedList();
       int[] indegree=new int[N];
       
       for(int i=0;i<N;i++){
           for(int j:list.get(i))
            indegree[j]++;
       }
       
       for(int i=0;i<N;i++){
           if(indegree[i]==0)
               queue.add(i);
       }
        List<Integer> res=new ArrayList();
        
        while(!queue.isEmpty()){
            int val=queue.poll();
            res.add(val);
            for(int j:list.get(val)){
                if(--indegree[j]==0){
                    queue.add(j);
                }
            }
        }
        int[] f=new int[N];
        for(int i=0;i<res.size();i++){
            f[i]=res.get(i);
        }
        //System.out.println();
        return f;
    }
